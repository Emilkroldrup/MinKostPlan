document.getElementById('survey').addEventListener('submit', function(event) {
    event.preventDefault();

    var checkboxes = document-this.querySelectorAll('input[type="checkbox"]');

    // Array to store selected input
    var selectedGoals = [];

    checkboxes.forEach(function(checkbox){
        if (checkbox.checked) {
            selectedGoals.push(checkbox.nextSibling.nodeValue.trim()); //Stores text after the trim
        }
    });
    // Displays the selected input from the user in console
    console.log('Selected goals: ', selectedGoals);
})