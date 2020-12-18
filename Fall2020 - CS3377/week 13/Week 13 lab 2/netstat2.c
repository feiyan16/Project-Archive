#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <string.h>

int main(int argc, char **argv){
    
    char string[100];
    char str[100] = "";
    char * end;
    char * begin;
    char * token;
    printf("Enter a port range: ");
    scanf("%s", string);
    token = strtok(string, "-");
    begin = token;
    while(token != NULL) {
        end = token;
        token = strtok(NULL, "-");
    }
    //printf("%d, %d", atoi(begin), atoi(end));
    
    for(int i = atoi(begin); i < atoi(end); i++) {
        FILE *fp;
        char path[1035];
        char s[100];
        char port[30];
        sprintf(port, "%d", i);
        strcpy(s, "netstat -aont | grep \"`hostname -i`:");
        strcat(s, port);
        strcat(s, "\" ");
        fp = popen(s, "r");
        if(fp == NULL) {
            printf("Failed to run command.\n");
            exit(1);
        }
        if (fgets(path, sizeof(path), fp) != NULL) {
            printf("Port #%d is not free\n", i);
        } else {
            printf("Port #%d is free\n", i);
        }

        pclose(fp);
    }
    
    return 0;
}
