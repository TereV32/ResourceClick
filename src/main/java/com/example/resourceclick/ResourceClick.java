package com.example.resourceclick;

/**
 *
 * @author teres
 */
public class ResourceClick {

    //Stats
    private int buttonClicked = 0;
    private int totalLand = 1000;
    private int freeLand = totalLand;
    private int totalBuildingd = 0;

    //Resources Count and Max Storage
    private double foodCnt = 0;
    private double woodCnt = 0;
    private double stoneCnt = 0;
    private int maxFoodStrge = 200;
    private int maxWoodStrge = 200;
    private int maxStoneStrge = 200;

    //Special Resources Count
    private int skinCnt = 0;
    private int herbCnt = 0;
    private int oreCnt = 0;
    private int leatherCnt = 0;
    private int pietyCnt = 0;
    private int metalCnt = 0;

    //Buildings Count
    private int tentCnt = 0;
    private int woodenHutCnt = 0;
    private int barnCnt = 0;
    private int woodStockPilesCnt = 0;
    private int stoneStockPilesCnt =0;

    //Population and Worker Count
    private int currPopCnt = 0;
    private int maxPopCnt = 0;
    private int unemplCnt = 0;
    private int farmerCnt = 0;
    private int woodCuttersCnt = 0;
    private int minersCnt = 0;
    private int tanners = 0;
    private int blacksmiths = 0;
    private int apothecary = 0;
    private int cleric = 0;
    private int soldiers = 0;

    //Production Rate
    private double foodProdTime = 0.0;
    private double woodProdTime = 0.0;
    private double stoneProdTime = 0.0;
    private double leatherProdTime = 0;
    private double pietyProdTime = 0;
    private double metalProdTime = 0;

    private double workerEat = 0.0;

    //Upgrades
    private boolean skinUpgrade = false;
    private boolean harvestUpgrade = false;
    private boolean prospectUpgrade = false;

    //Stats
    public int getButtonClicked() {
        return buttonClicked;
    }
    public void setButtonClicked(int buttonClicked) {
        this.buttonClicked = buttonClicked;
    }
    public int getTotalLand() {
        return totalLand;
    }
    public void setTotalLand(int totalLand) {
        this.totalLand = totalLand;
    }
    public int getFreeLand() {
        return freeLand;
    }
    public void setFreeLand(int freeLand) {
        this.freeLand = freeLand;
    }
    public int getTotalBuildingd() {
        return totalBuildingd;
    }
    public void setTotalBuildingd(int totalBuildingd) {
        this.totalBuildingd = totalBuildingd;
    }


    //Food
    public double getFoodCnt() {
        return foodCnt;
    }
    public void setFoodCnt(double foodCnt) {
        this.foodCnt = foodCnt;
    }
    public int getMaxFoodStrge() {
        return maxFoodStrge;
    }
    public void setMaxFoodStrge(int maxFoodStrge) {
        this.maxFoodStrge = maxFoodStrge;
    }

    //Wood
    public double getWoodCnt() {
        return woodCnt;
    }
    public void setWoodCnt(double woodCnt) {
        this.woodCnt = woodCnt;
    }
    public int getMaxWoodStrge() {
        return maxWoodStrge;
    }
    public void setMaxWoodStrge(int maxWoodStrge) {
        this.maxWoodStrge = maxWoodStrge;
    }

    //Stone
    public double getStoneCnt() {
        return stoneCnt;
    }
    public void setStoneCnt(double stoneCnt) {
        this.stoneCnt = stoneCnt;
    }
    public int getMaxStoneStrge() {
        return maxStoneStrge;
    }
    public void setMaxStoneStrge(int maxStoneStrge) {
        this.maxStoneStrge = maxStoneStrge;
    }

    //Skin
    public int getSkinCnt() {
        return skinCnt;
    }
    public void setSkinCnt(int skinCnt) {
        this.skinCnt = skinCnt;
    }
    public boolean isSkinUpgrade() {
        return skinUpgrade;
    }
    public void setSkinUpgrade(boolean skinUpgrade) {
        this.skinUpgrade = skinUpgrade;
    }

    //Leather
    public int getLeatherCnt() {
        return leatherCnt;
    }
    public void setLeatherCnt(int leatherCnt) {
        this.leatherCnt = leatherCnt;
    }
    public double getLeatherProdTime() {
        return leatherProdTime;
    }
    public void setLeatherProdTime(double leatherProdTime) {
        this.leatherProdTime = leatherProdTime;
    }

    //Herb
    public int getHerbCnt() {
        return herbCnt;
    }
    public void setHerbCnt(int herbCnt) {
        this.herbCnt = herbCnt;
    }

    public boolean isHarvestUpgrade() {
        return harvestUpgrade;
    }
    public void setHarvestUpgrade(boolean harvestUpgrade) {
        this.harvestUpgrade = harvestUpgrade;
    }

    //Piety
    public int getPietyCnt() {
        return pietyCnt;
    }
    public void setPietyCnt(int pietyCnt) {
        this.pietyCnt = pietyCnt;
    }
    public double getPietyProdTime() {
        return pietyProdTime;
    }
    public void setPietyProdTime(double pietyProdTime) {
        this.pietyProdTime = pietyProdTime;
    }

    //Ore
    public int getOreCnt() {
        return oreCnt;
    }
    public void setOreCnt(int oreCnt) {
        this.oreCnt = oreCnt;
    }
    public boolean isProspectUpgrade() {
        return prospectUpgrade;
    }
    public void setProspectUpgrade(boolean prospectUpgrade) {
        this.prospectUpgrade = prospectUpgrade;
    }

    //Metal
    public int getMetalCnt() {
        return metalCnt;
    }
    public void setMetalCnt(int metalCnt) {
        this.metalCnt = metalCnt;
    }
    public double getMetalProdTime() {
        return metalProdTime;
    }
    public void setMetalProdTime(double metalProdTime) {
        this.metalProdTime = metalProdTime;
    }

    //Tent
    public int getTentCnt() {
        return tentCnt;
    }
    public void setTentCnt(int tentCnt) {
        this.tentCnt = tentCnt;
    }

    //WoodenHut
    public int getWoodenHutCnt() {
        return woodenHutCnt;
    }
    public void setWoodenHutCnt(int woodenHutCnt) {
        this.woodenHutCnt = woodenHutCnt;
    }

    //Storage Buildings
    public int getBarnCnt() {
        return barnCnt;
    }
    public void setBarnCnt(int barnCnt) {
        this.barnCnt = barnCnt;
    }
    public int getWoodStockPilesCnt() {
        return woodStockPilesCnt;
    }
    public void setWoodStockPilesCnt(int woodStockPilesCnt) {
        this.woodStockPilesCnt = woodStockPilesCnt;
    }
    public int getStoneStockPilesCnt() {
        return stoneStockPilesCnt;
    }
    public void setStoneStockPilesCnt(int stoneStockPilesCnt) {
        this.stoneStockPilesCnt = stoneStockPilesCnt;
    }


    //Population
    public int getCurrPopCnt() {
        return currPopCnt;
    }
    public void setCurrPopCnt(int currPopCnt) {
        this.currPopCnt = currPopCnt;
    }
    public int getMaxPopCnt() {
        return maxPopCnt;
    }
    public void setMaxPopCnt(int maxPopCnt) {
        this.maxPopCnt = maxPopCnt;
    }
    public int getUnemplCnt() {
        return unemplCnt;
    }
    public void setUnemplCnt(int unemplCnt) {
        this.unemplCnt = unemplCnt;
    }

    //Workers
    public int getFarmerCnt() {
        return farmerCnt;
    }
    public void setFarmerCnt(int farmerCnt) {
        this.farmerCnt = farmerCnt;
    }
    public int getWoodCuttersCnt() {
        return woodCuttersCnt;
    }
    public void setWoodCuttersCnt(int woodCuttersCnt) {
        this.woodCuttersCnt = woodCuttersCnt;
    }
    public int getMinersCnt() {
        return minersCnt;
    }
    public void setMinersCnt(int minersCnt) {
        this.minersCnt = minersCnt;
    }
    public int getTanners() {
        return tanners;
    }
    public void setTanners(int tanners) {
        this.tanners = tanners;
    }
    public int getBlacksmiths() {
        return blacksmiths;
    }
    public void setBlacksmiths(int blacksmiths) {
        this.blacksmiths = blacksmiths;
    }
    public int getApothecary() {
        return apothecary;
    }
    public void setApothecary(int apothecary) {
        this.apothecary = apothecary;
    }
    public int getCleric() {
        return cleric;
    }
    public void setCleric(int cleric) {
        this.cleric = cleric;
    }
    public int getSoldiers() {
        return soldiers;
    }
    public void setSoldiers(int soldiers) {
        this.soldiers = soldiers;
    }

    //Produce Time
    public double getFoodProdTime() {
        return foodProdTime;
    }
    public void setFoodProdTime(double foodProdTime) {
        this.foodProdTime = foodProdTime;
    }
    public double getWoodProdTime() {
        return woodProdTime;
    }
    public void setWoodProdTime(double woodProdTime) {
        this.woodProdTime = woodProdTime;
    }
    public double getStoneProdTime() {
        return stoneProdTime;
    }
    public void setStoneProdTime(double stoneProdTime) {
        this.stoneProdTime = stoneProdTime;
    }

    //Workers food intake
    public double getWorkerEat() {
        return workerEat;
    }
    public void setWorkerEat(double workerEat) {
        this.workerEat = workerEat;
    }




}
