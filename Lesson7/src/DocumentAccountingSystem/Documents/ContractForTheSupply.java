package DocumentAccountingSystem.Documents;

import java.util.Date;

public class ContractForTheSupply extends Documents implements Informatinable
{
    private String goodsType;
    private int goodsCount;

    public ContractForTheSupply()
    {

    }

    public ContractForTheSupply(int documentNumber, Date documentDate, String goodsType, int goodsCount)
    {
        super(documentNumber, documentDate);
        this.goodsType = goodsType;
        this.goodsCount = goodsCount;
    }

    public String getGoodsType()
    {
        return goodsType;
    }

    public void setGoodsType(String goodsType)
    {
        this.goodsType = goodsType;
    }

    public int getGoodsCount()
    {
        return goodsCount;
    }

    public void setGoodsCount(int goodsCount)
    {
        this.goodsCount = goodsCount;
    }

    @Override
    public void outputInformation()
    {
        System.out.println("Номер документа: " + this.documentNumber + "\nДата документа: " + this.documentDate.toLocaleString()
                + "\nТип товаров: " + this.goodsType + "\nКол-во товаров: " + this.goodsCount);
    }
}
