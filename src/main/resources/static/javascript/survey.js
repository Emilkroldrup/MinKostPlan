function nextStep(currentStep) {
    var currentDiv = document.getElementById("step" + currentStep);
    var nextDiv = document.getElementById("step" + (currentStep + 1));
    if (nextDiv) {
        currentDiv.style.display = "none";
        nextDiv.style.display = "block";
    }
}

document.getElementById("surveyForm").addEventListener("submit", function(event) {
    event.preventDefault();

    var formData = new FormData(event.target);

    fetch("/survey", {
        method: "POST",
        body: formData
    })
    .then(response => response.text())
    .then(result => {
        console.log('Success:', result);
        // redirect to the home page
    })
    .catch(error => {
        console.error('Error:', error);
    });
});