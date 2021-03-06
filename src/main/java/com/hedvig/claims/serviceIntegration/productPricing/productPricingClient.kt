package com.hedvig.claims.serviceIntegration.productPricing

import com.hedvig.claims.config.FeignConfiguration
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(
    name = "productPricingClient",
    url = "\${hedvig.productPricing.url:product-pricing}",
    configuration = [FeignConfiguration::class]
)
interface ProductPricingClient {
    @GetMapping("/_/contracts/members/{memberId}")
    fun getContractsByMemberId(@PathVariable("memberId") memberId: String): ResponseEntity<List<Contract>>
}
