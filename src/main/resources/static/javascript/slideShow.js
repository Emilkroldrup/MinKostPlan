let slideIndex = 0;

function showSlides() {
    let slides = document.getElementsByClassName("mySlides");
    for (let i = 0; i < slides.length; i++) {
        let img = slides[i].getElementsByTagName('img')[0];
        img.style.opacity = (i === slideIndex ? "1" : "0");
    }
    slideIndex = (slideIndex + 1) % slides.length;
    setTimeout(showSlides, 6000);
}


// Initialize the slideshow
document.addEventListener("DOMContentLoaded", function() {
    setTimeout(showSlides, 1000);
});
