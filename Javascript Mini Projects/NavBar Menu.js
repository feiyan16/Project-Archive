/*eslint-env es6*/
/* eslint-env browser */
const navbarBtn = document.querySelector('.navbar_btns');
const navbarLinks = document.querySelector('.navbar_links');

navbarBtn.addEventListener('click', function() {
    let value = navbarLinks.classList.contains('navbar_collapse');
    
    if (value) {
        navbarLinks.classList.remove('navbar_collapse');
        navbarBtn.classList.remove('change');
    } else {
        navbarLinks.classList.add('navbar_collapse');
        navbarBtn.classList.add('change');
    }
})