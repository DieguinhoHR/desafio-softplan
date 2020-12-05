package sofplan.softplayer.core.security;

public class SecurityConstants {
    // Authorization Bearer uheauhehgy3u231uh
    static final String SECRET = "secret";
    static final String TOKEN_PREFIX = "Bearer ";
    static final String HEADER_STRING = "Authorization";
    static final String SIGN_UP_URL = "/users/sign-up";
    static final long EXPIRATION_TIME = 86400000L; // dura um dia
}
