//package outbound;
//
//
//import jakarta.enterprise.context.ApplicationScoped;
//
//@ApplicationScoped
//public class EmailSenderFactory {
//    public EmailSender getEmailSender(ProcessingModel processingModel, SecurityModel securityModel) {
//        if (securityModel == SecurityModel.SECURE) {
//            return switch (processingModel) {
//                case REACTIVE -> new ReactiveSecureEmailSender();
//                case IMPERATIVE -> new ImperativeSecureEmailSender();
//                case ASYNC -> new AsyncSecureEmailSender();
//                default -> throw new IllegalArgumentException("Unsupported processing model");
//            };
//        } else {
//            return switch (processingModel) {
//                case REACTIVE -> new ReactiveEmailSender();
//                case IMPERATIVE -> new ImperativeEmailSender();
//                case ASYNC -> new AsyncEmailSender();
//                default -> throw new IllegalArgumentException("Unsupported processing model");
//            };
//        }
//    }
//}