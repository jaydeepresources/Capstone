import { Category } from '../model/category';

export class Item {

    itemId: number
    itemName: string
    itemMinPrice: number
    itemDescription: string
    itemImg: string

    category: any

    constructor() {
        this.itemId = 0
        this.itemName = ''
        this.itemMinPrice = 0
        this.itemDescription = ''
        this.itemImg = ''
        this.category = new Category
    }
}