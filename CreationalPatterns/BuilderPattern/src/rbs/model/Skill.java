package rbs.model;

public class Skill {

    private final String name;
    private final String level;

    private Skill(SkillBuilder builder) {
        this.name = builder.name;
        this.level = builder.level;
    }

    public static SkillBuilder builder() {
        return new SkillBuilder();
    }

    @Override
    public String toString() {
        return String.format("- %s (%s)", name, level != null ? level : "Basic");
    }

    public static class SkillBuilder {
        private String name;
        private String level;

        public SkillBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public SkillBuilder withLevel(String level) {
            this.level = level;
            return this;
        }

        public Skill build() {
            if (name == null || name.isBlank()) {
                throw new IllegalStateException("Skill name is required.");
            }
            return new Skill(this);
        }
    }
}