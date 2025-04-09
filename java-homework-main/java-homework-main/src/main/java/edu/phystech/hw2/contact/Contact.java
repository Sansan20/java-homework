package edu.phystech.hw2.contact;


record Contact(String username, String email) implements Comparable<Contact> {
    public static final String UNKNOWN_EMAIL = "unknown";

    Contact(String username, String email) {
        if (username == null || username.trim().isEmpty()) {
            throw new InvalidContactFieldException("username");
        }

        if (email == null || email.trim().isEmpty()) {
            email = UNKNOWN_EMAIL;
        } else if (!UNKNOWN_EMAIL.equals(email) && !email.matches("^[^\\s@]+@gmail\\.com$")) {
            throw new InvalidContactFieldException("email");
        }

        this.username = username;
        this.email = email;
    }

    Contact(String username) {
        this(username, UNKNOWN_EMAIL);
    }

    @Override
    public int compareTo(Contact o) {
        int len1 = this.username.length();
        int len2 = o.username.length();
        if (len1 < len2) return -1;
        if (len1 > len2) return 1;
        return 0;
    }

}
