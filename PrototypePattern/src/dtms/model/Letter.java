package dtms.model;

import static dtms.utils.DateTimeUtils.millisToDateTime;

public class Letter implements Document {

    private final String recipient;
    private final String sender;
    private final String subject;
    private final String body;
    private final Document attachment;
    private final Long createdAt;

    private Letter(LetterBuilder builder) {
        this.recipient = builder.recipient;
        this.sender = builder.sender;
        this.subject = builder.subject;
        this.body = builder.body;
        this.attachment = builder.attachment;
        this.createdAt = System.currentTimeMillis();
    }

    public static LetterBuilder builder() {
        return new LetterBuilder();
    }

    @Override
    public Document cloneDocument() {
        return Letter.builder()
                .withRecipient(this.recipient)
                .withSender(this.sender)
                .withSubject(this.subject)
                .withBody(this.body)
                .withAttachment(this.attachment != null ? this.attachment.cloneDocument() : null)
                .build();
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n--- Letter ---\n")
                .append("From       : ").append(sender).append("\n")
                .append("To         : ").append(recipient).append("\n")
                .append("Subject    : ").append(subject).append("\n")
                .append("Body       : ").append(body).append("\n")
                .append("Created At : ").append(millisToDateTime(createdAt)).append("\n");
        if (attachment != null) {
            sb.append("Attachment : ").append("\n").append(attachment);
        }
        sb.append("--------------------------\n");
        return sb.toString();
    }

    public static class LetterBuilder {
        private String recipient;
        private String sender;
        private String subject;
        private String body;
        private Document attachment;

        public LetterBuilder withRecipient(String recipient) {
            this.recipient = recipient;
            return this;
        }

        public LetterBuilder withSender(String sender) {
            this.sender = sender;
            return this;
        }

        public LetterBuilder withSubject(String subject) {
            this.subject = subject;
            return this;
        }

        public LetterBuilder withBody(String body) {
            this.body = body;
            return this;
        }

        public LetterBuilder withAttachment(Document attachment) {
            this.attachment = attachment;
            return this;
        }

        public Letter build() {
            if (recipient == null || sender == null || subject == null || body == null) {
                throw new IllegalStateException("All letter fields are required");
            }
            return new Letter(this);
        }
    }
}