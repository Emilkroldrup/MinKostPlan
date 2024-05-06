document.addEventListener("DOMContentLoaded", function() {
    const slides = document.querySelectorAll('.mySlides');
    let currentSlide = 0;

    function showSlide() {
        // Hide all slides by setting their opacity to 0
        slides.forEach((slide) => {
            slide.style.opacity = '0';
            slide.classList.remove('active');
        });

        // Make the current slide visible
        slides[currentSlide].classList.add('active');
        slides[currentSlide].style.opacity = '1';

        // Move to the next slide
        currentSlide = (currentSlide + 1) % slides.length;

        // Set a timeout to show the next slide after 3 seconds
        setTimeout(showSlide, 4000);
    }

    // Initialize the slideshow
    showSlide();
});
