package org.example.sociallogin.domain.social

enum class OauthProvider {
    GOOGLE
    ;

    companion object {
        fun of(value: String): OauthProvider {
            return entries.first { it.name.equals(value, ignoreCase = true) }
        }
    }
}