package minkostplan.application.entity;

public class Step {

    private Long stepId;
    private Recipe recipe;
    private int stepNumber;
    private String instruction;

    public Step() {
    }

    public Step(Long stepId, Recipe recipe, int stepNumber, String instruction) {
        this.stepId = stepId;
        this.recipe = recipe;
        this.stepNumber = stepNumber;
        this.instruction = instruction;
    }

    public Long getStepId() {
        return this.stepId;
    }

    public void setStepId(Long stepId) {
        this.stepId = stepId;
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
            " stepId='" + getStepId() + "'" +
            ", recipe='" + getRecipe() + "'" +
            ", stepNumber='" + getStepNumber() + "'" +
            ", instruction='" + getInstruction() + "'" +
            "}";
    }
}
