package minkostplan.application.entity;

public class Step {

    private Recipe recipe;
    private int stepNumber;
    private String instruction;

    public Step() {
    }

    public Step(Recipe recipe, int stepNumber, String instruction) {
        this.recipe = recipe;
        this.stepNumber = stepNumber;
        this.instruction = instruction;
    }

    public Recipe getRecipe() {
        return this.recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public int getStepNumber() {
        return this.stepNumber;
    }

    public void setStepNumber(int stepNumber) {
        this.stepNumber = stepNumber;
    }

    public String getInstruction() {
        return this.instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    @Override
    public String toString() {
        return "{" +
            ", recipe='" + getRecipe() + "'" +
            ", stepNumber='" + getStepNumber() + "'" +
            ", instruction='" + getInstruction() + "'" +
            "}";
    }
}
