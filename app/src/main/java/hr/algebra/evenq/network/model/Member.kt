package hr.algebra.evenq.network.model

import java.io.Serializable

class Member(
    val uid: String,
    val firstName: String,
    val lastName: String,
    val refferalCode: String,
    val isAdmin: String,
    val numberOfRefferals: Int,
    val membershipValid: String
): Serializable {
}