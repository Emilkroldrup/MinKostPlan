// For at tilføje et input felt når man trykker på plus
document.addEventListener('DOMContentLoaded', function() {
    var addButton = document.querySelector('.addIngredient');
    var ingredientSection = document.querySelector('.ingredient');

    addButton.addEventListener('click', function() {
        var ingredientInput = document.createElement('input');
        ingredientInput.type = 'text';
        ingredientInput.placeholder = 'Indtast ingrediens...';
        ingredientInput.classList.add('ingredient-input');

        var descriptionInput = document.createElement('input');
        descriptionInput.type = 'text';
        descriptionInput.placeholder = 'Indtast en beskrivelse af produktet..';
        descriptionInput.classList.add('description-input');

        var button = document.createElement('button');
        button.textContent = 'Fjern';

        var container = document.createElement('div');
        container.appendChild(ingredientInput);
        container.appendChild(descriptionInput);
        container.appendChild(button);

        container.classList.add('addIng');

        ingredientSection.appendChild(container);

        button.addEventListener('click', function() {
            container.remove();
        });
    });
});

// For at tilføje et billede med "Tilføj billede" knappen
document.getElementById('fileInput').addEventListener('change', function(event) {
    var file = event.target.files[0];
    var reader = new FileReader();

    reader.onload = function(e) {
        var img = document.getElementById('previewImage');
        img.src = e.target.result;
        img.style.display = 'block';
    };

    reader.readAsDataURL(file);
});