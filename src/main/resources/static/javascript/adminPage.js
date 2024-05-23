// Creates image button, image preview, adds ingredients, and handles form submission
document.addEventListener('DOMContentLoaded', function() {
    const addButton = document.querySelector('.addIngredient');
    const ingredientSection = document.querySelector('.ingredient');
    const form = document.querySelector('form');
    const fileInput = document.getElementById('fileInput');
    const previewImage = document.getElementById('previewImage');

    addButton.addEventListener('click', function() {
        const ingredientInput = createInput('text', 'Indtast ingrediens...', 'ingredient-input');
        const descriptionInput = createInput('text', 'Indtast en beskrivelse af produktet..', 'description-input');
        const button = createButton('Fjern');

        const container = document.createElement('div');
        container.classList.add('addIng');
        container.appendChild(ingredientInput);
        container.appendChild(descriptionInput);
        container.appendChild(button);
        ingredientSection.appendChild(container);

        button.addEventListener('click', function() {
            container.remove();
        });
    });

    // Event listener for form submission
    form.addEventListener('submit', function(event) {
        event.preventDefault(); // Prevent default form submission

        const ingredientInputs = document.querySelectorAll('.ingredient-input');
        const descriptionInputs = document.querySelectorAll('.description-input');

        const ingredients = Array.from(ingredientInputs).map(input => input.value.trim()).filter(Boolean);
        const descriptions = Array.from(descriptionInputs).map(input => input.value.trim());

        form.querySelector('[name="ingredients"]').value = ingredients.join(',');
        form.querySelector('[name="descriptions"]').value = descriptions.join(',');

        form.submit();
    });

    // Event listener for file input change
    fileInput.addEventListener('change', function(event) {
        const file = event.target.files[0];
        const reader = new FileReader();

        reader.onload = function(e) {
            previewImage.src = e.target.result;
            previewImage.style.display = 'block';
        };

        reader.readAsDataURL(file);
    });

    // Function to create input elements
    function createInput(type, placeholder, className) {
        const input = document.createElement('input');
        input.type = type;
        input.placeholder = placeholder;
        input.classList.add(className);
        return input;
    }

    // Function to create button elements
    function createButton(text) {
        const button = document.createElement('button');
        button.textContent = text;
        return button;
    }
});