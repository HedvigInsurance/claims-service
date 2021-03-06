package com.hedvig.claims.commands

import com.hedvig.claims.query.Carrier
import org.axonframework.commandhandling.TargetAggregateIdentifier

data class AddPaymentCommand(
    val id: String,
    @TargetAggregateIdentifier
    val claimID: String,
    val amount: Double,
    val deductible: Double,
    val note: String,
    val exGratia: Boolean,
    val handlerReference: String,
    val carrier: Carrier
)
