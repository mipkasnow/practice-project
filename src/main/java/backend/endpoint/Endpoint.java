package backend.endpoint;

public class Endpoint {

    public static class Auth {
        public static class Get {

        }

        public static class Post {
            public static String login() {return "/auth/api/user/login";}
        }
    }

    public static class Ccwe {
        public static class Get {

        }

        public static class Post {
            public static String newsPublishedList() {return "/ccwe/news/newsPublishedList";}
        }
    }
}
