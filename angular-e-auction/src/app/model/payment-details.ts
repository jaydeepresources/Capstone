export class PaymentDetails {
    cardNo: string
    cardName: string
    cardExpiry: string
    cardCVV: string

    constructor() {
        this.cardNo = ''
        this.cardName = ''
        this.cardExpiry = ''
        this.cardCVV = ''
    }

}