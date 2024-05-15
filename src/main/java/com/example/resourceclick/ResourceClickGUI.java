/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.resourceclick;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author teres
 */
public class ResourceClickGUI extends Application {

    //Population Labels
    private Label currPop;
    private Label unempl;
    private Label maxPop;

    //Stats Labels
    private Label resourcesClicked;
    private Label totalLand;
    private Label totalBuildings;
    private Label freeLand;

    //Max Storage
    private Label foodStorage;
    private Label woodStorage;
    private Label stoneStorage;

    //Worker Labels
    private Label farmers;
    private Label woodCutters;
    private Label miners;
    private Label tanners;
    private Label blacksmiths;
    private Label apothecaries;
    private Label clerics;
    private Label soldiers;

    //Production rate of resources labels
    private Label foodProd;
    private Label woodProd;
    private Label stoneProd;

    //Resources count Labels
    private Label foodCount;
    private Label woodCount;
    private Label stoneCount;

    //Special Resources Labels
    private Label skins;
    private Label herbs;
    private Label ores;
    private Label leather;
    private Label piety;
    private Label metal;

    //Gather Resources Buttons
    private Button gathFood;
    private Button gathStone;
    private Button gathWood;

    //Buildings Labels
    private Label barns;
    private Label woodStockPiles;
    private Label stoneStockPiles;

    //VBox
    private VBox purchasedVB;
    private VBox upgradesVB;
    private VBox buildingTabs;
    private VBox firstUpgrBuildings;
    private VBox jobsVB;

    //Building HBox
    private HBox tanneryHB;
    private HBox smithHB;
    private HBox apothecaryHB;
    private HBox templeHB;
    private HBox barracksHB;

    //Jobs HBox
    private HBox tannersHB;
    private HBox apothecariesHB;
    private HBox clericsHB;
    private HBox blacksmithsHB;
    private HBox soldiersHB;

    //Upgrade HBox
    private HBox skinUpgrHB;
    private HBox harvestUpgrHB;
    private HBox prospectHB;
    private HBox masonaryHB;
    private HBox domesticationHB;
    private HBox ploughSharesHB;
    private HBox irrigationHB;
    private HBox constructionHB;
    private HBox granariesHB;
    private HBox basicWeaponHB;
    private HBox basicShieldHB;
    private HBox horsebackRidingHB;
    private HBox writingHB;
    private HBox wheetHB;

    ResourceClick game = new ResourceClick();

    @Override
    public void start(Stage primaryStage) {

        //Left Side

        //Special Resources Tab
        skins = new Label("Skins: " + game.getSkinCnt());
        herbs = new Label("Herbs: " + game.getHerbCnt());
        ores = new Label("Ores: " + game.getOreCnt());
        VBox spclRes = new VBox(20, skins, herbs, ores);

        //Special Res Images
        ImageView skinImg = new ImageView(new Image("http://dhmstark.co.uk/games/civclicker/skins.png"));
        skinImg.setPreserveRatio(true); skinImg.setFitHeight(30);
        ImageView herbImg = new ImageView(new Image("http://dhmstark.co.uk/games/civclicker/herbs.png"));
        herbImg.setPreserveRatio(true); herbImg.setFitHeight(30);
        ImageView oreImg = new ImageView(new Image("http://deathraygames.com/play-online/civ-clicker/images/ore.png"));
        oreImg.setPreserveRatio(true); oreImg.setFitHeight(30);
        VBox specResImg = new VBox(15, skinImg, herbImg, oreImg);
        HBox specResHB = new HBox(10, spclRes, specResImg);
        //Basic Resources Side
        Label basicRes = new Label("Basic Resources");

        foodCount = new Label("Food: " + String.format("%.0f", game.getFoodCnt()));
        woodCount = new Label("Wood: " + String.format("%.0f", game.getWoodCnt()));
        stoneCount = new Label("Stone: " + String.format("%.0f", game.getStoneCnt()));
        VBox resCount = new VBox(30, foodCount, woodCount, stoneCount);
        resCount.setAlignment(Pos.CENTER);

        foodStorage = new Label("Max Storage: " + game.getMaxFoodStrge());
        woodStorage = new Label("Max Storage: " + game.getMaxWoodStrge());
        stoneStorage = new Label("Max Storeage: " + game.getMaxStoneStrge());
        VBox storage = new VBox(30, foodStorage, woodStorage, stoneStorage);
        storage.setAlignment(Pos.CENTER);

        //Basic Res Images
        ImageView wheat = new ImageView(new Image("http://dhmholley.co.uk/food.png"));
        wheat.setPreserveRatio(true); wheat.setFitHeight(30);
        ImageView tree = new ImageView(new Image("http://dhmholley.co.uk/wood.png"));
        tree.setPreserveRatio(true); tree.setFitHeight(30);
        ImageView stone = new ImageView(new Image("http://dhmholley.co.uk/stone.png"));
        stone.setPreserveRatio(true); stone.setFitHeight(30);
        VBox resImage = new VBox(30, wheat, tree, stone);

        //Resources Production Rate
        foodProd = new Label();
        woodProd = new Label();
        stoneProd = new Label();
        VBox production = new VBox(20, foodProd, woodProd, stoneProd);

        //Gather Resources Buttons
        gathFood = new Button("Gather Food");
        gathFood.setOnAction(new FoodButton());

        gathWood = new Button("Gather Wood");
        gathWood.setOnAction(new WoodButton());

        gathStone = new Button("Gather Stone");
        gathStone.setOnAction(new StoneButton());

        VBox basicBtns = new VBox(20, gathFood, gathWood, gathStone);
        basicBtns.setAlignment(Pos.CENTER);
        HBox basicResHB = new HBox(20, basicBtns, resCount, resImage, storage, production);
        basicResHB.setPadding(new Insets(10));
        VBox basicResVB = new VBox(10, basicRes, basicResHB);

        //Buildings Side
        Label buildLbl = new Label("Buildings");

        //Houses 
        Label tentLbl = new Label("Tents:       " + game.getTentCnt() + "      2 skins, 2 wood: +1 max pop.");
        Label woodenHutLbl = new Label("Wooden Hut:       " + game.getWoodenHutCnt() + "      1 skin, 20 wood: +3 max pop.");
        Button tentBtn = new Button("Build Tent");
        tentBtn.setOnAction((ActionEvent event) -> {
            if(game.getSkinCnt() >= 2 && game.getWoodCnt() >= 2)
            {
                game.setMaxPopCnt(game.getMaxPopCnt()+1);
                maxPop.setText("Maximum Population: " + game.getMaxPopCnt());
                game.setSkinCnt(game.getSkinCnt()-2);
                skins.setText("Skins: " + game.getSkinCnt());
                game.setWoodCnt(game.getWoodCnt()-2);
                woodCount.setText("Wood: " + String.format("%.0f", game.getWoodCnt()));
                game.setTentCnt(game.getTentCnt()+1);
                tentLbl.setText("Tents:       " + game.getTentCnt() + "      2 skins, 2 wood: +1 max pop.");
                game.setFreeLand(game.getFreeLand()-1);
                freeLand.setText("Free Land: " + game.getFreeLand());
                game.setTotalBuildingd(game.getTotalBuildingd()+1);
                totalBuildings.setText("Total Buildings: " + game.getTotalBuildingd());
            }
        });
        Button woodenHutBtn = new Button("Build Wooden Hut");
        woodenHutBtn.setOnAction((ActionEvent event) -> {
            if(game.getSkinCnt() >= 2 && game.getWoodCnt() >= 20)
            {
                game.setMaxPopCnt(game.getMaxPopCnt()+3);
                maxPop.setText("Maximum Population: " + game.getMaxPopCnt());
                game.setSkinCnt(game.getSkinCnt()-1);
                skins.setText("Skins: " + game.getSkinCnt());
                game.setWoodCnt(game.getWoodCnt()-20);
                woodCount.setText("Wood: " + String.format("%.0f", game.getWoodCnt()));
                game.setWoodenHutCnt(game.getWoodenHutCnt()+1);
                woodenHutLbl.setText("Wooden Hut:       " + game.getWoodenHutCnt() + "      1 skin, 20 wood: +3 max pop.");
                game.setFreeLand(game.getFreeLand()-1);
                freeLand.setText("Free Land: " + game.getFreeLand());
                game.setTotalBuildingd(game.getTotalBuildingd()+1);
                totalBuildings.setText("Total Buildings: " + game.getTotalBuildingd());
            }
        });
        HBox tentHB = new HBox(15, tentBtn, tentLbl);
        HBox woodenHutHB = new HBox(15, woodenHutBtn, woodenHutLbl);

        //Storage Buildings
        barns = new Label("Barns:       " + game.getBarnCnt() + "       100 wood: store +200 food");
        woodStockPiles = new Label("Wood StockPiles:       " + game.getWoodStockPilesCnt() + "       100 wood: store +200 wood");
        stoneStockPiles = new Label("Stone StockPiles:       " + game.getStoneStockPilesCnt() + "       100 wood: store +200 stone");

        Button buildBarn = new Button("Build Barn");
        buildBarn.setOnAction(new barnButton());
        Button buildWoodStockPile = new Button("Build Wood StockPile");
        buildWoodStockPile.setOnAction(new woodStockPileButton());
        Button buildStoneStockPile = new Button("Build Stone StockPile");
        buildStoneStockPile.setOnAction(new stoneStockPileButton());
        HBox barnHB = new HBox(15, buildBarn, barns);
        HBox woodStockPilesHB = new HBox(15, buildWoodStockPile, woodStockPiles);
        HBox stoneStockPilesHB = new HBox(15, buildStoneStockPile, stoneStockPiles);

        Label tanneries = new Label("Tanneries:	" + game.getTanners() + "	30 Wood, 70 Stone, 2 Skins: +1 Tanner");
        Button buildTannery = new Button("Build Tannery");
        buildTannery.setOnAction(new tanneryButton());
        buildTannery.setOnAction(new tanneryButton());
        tanneryHB = new HBox(15, buildTannery, tanneries);
        Label smiths = new Label("Smithies:	" + game.getBlacksmiths() + "	 30 wood, 70 stone, 2 ore: allows 1 blacksmith");
        Button buildSmiths = new Button("Build Smiths");
        buildSmiths.setOnAction(new smithsButton());
        smithHB = new HBox(15, buildSmiths, smiths);
        Label apothecary = new Label("Apothecaries:	"+ game.getApothecary()+ "	30 wood, 70 stone, 2 herbs: allows 1 apothecary");
        Button buildApothecary = new Button("Build Apothecary");
        buildApothecary.setOnAction(new apothecaryButton());
        apothecaryHB = new HBox(15, buildApothecary, apothecary);
        Label temple = new Label("Temples:	"+ game.getCleric()+"	30 wood, 120 stone, 10 herbs: allows 1 cleric");
        Button buildTemple = new Button("Build Temple");
        buildTemple.setOnAction(new templeButton());
        templeHB = new HBox(15, buildTemple, temple);
        Label barracks = new Label("Barracks:	" + game.getSoldiers()+ "		20 food, 60 wood, 120 stone, 10 metal: allows 10 soldiers");
        Button buildBarracks = new Button("Build Barracks");
        buildBarracks.setOnAction(new barracksButton());
        barracksHB = new HBox(15, buildBarracks, barracks);
        VBox storageBuildings = new VBox(15, barnHB, woodStockPilesHB, stoneStockPilesHB);
        firstUpgrBuildings = new VBox(15, tanneryHB, smithHB, apothecaryHB, templeHB, barracksHB);
        VBox buildingsVB = new VBox(15, tentHB, woodenHutHB);
        buildingTabs = new VBox(40, buildingsVB, storageBuildings);

        //Upgrades
        Label skinUpgrLabel = new Label("10 Skins: Farmers can collect skin");
        Button skinUpgrades = new Button("Skinning");
        skinUpgrades.setOnAction(new skinUpgradeButton());
        skinUpgrHB = new HBox(10, skinUpgrades, skinUpgrLabel);
        Label harvestUpgrLabel = new Label("10 Herbs: Woodcutters can collect herbs");
        Button harvestUpgrade = new Button("Harvesting");
        harvestUpgrade.setOnAction(new harvestUpgradeButton());
        harvestUpgrHB = new HBox(10, harvestUpgrade, harvestUpgrLabel);
        Label prospectUpgrLabel = new Label("10 Ore: Miners can collect ores");
        Button prospectUpgrade = new Button("Prospecting");
        prospectUpgrade.setOnAction(new prospectUpgradeButton());
        prospectHB = new HBox(10, prospectUpgrade, prospectUpgrLabel);
        Label masonaryLbl = new Label("100 Wood, 100 Stone: Unlock more buildings and upgrades");
        Button masonaryUpgrade = new Button("Masonary");
        masonaryUpgrade.setOnAction(new masonaryUpgradeButton());
        masonaryHB = new HBox(10,masonaryUpgrade, masonaryLbl);
        Label domestLbl = new Label("20 Leather: Increase farmer food output");
        Button domestUpgrade = new Button("Domestication");
        domesticationHB = new HBox(10, domestUpgrade, domestLbl);
        Label ploughSharesLbl = new Label("20 Metal: Increase farmer food output");
        Button ploughShareUpgrade = new Button("Ploughshares");
        ploughSharesHB = new HBox(10, ploughShareUpgrade, ploughSharesLbl);
        Label irrigationLbl = new Label("500 Wood, 500 Leather: Increase farmer food output");
        Button irrigationUpgrade = new Button("Irrigation");
        irrigationHB = new HBox(10, irrigationUpgrade, irrigationLbl);
        Label constructionLbl = new Label("1000 Wood, 1000 Stone: Unlock more buildings and upgrades");
        Button constructionUpgrade = new Button("Construction");
        constructionHB = new HBox(10, constructionUpgrade, constructionLbl);
        Label granariesLbl = new Label("1000 Wood, 1000 Stone: Barns store double the amount of food");
        Button granariesUpgrade = new Button("Granaries");
        granariesHB = new HBox(10, granariesUpgrade, granariesLbl);
        Label basicWeaponLbl = new Label("500 Wood, 500 metal: Improve soldiers");
        Button basicWeaponUpgrade = new Button("Basic Weaponary");
        basicWeaponHB = new HBox(10, basicWeaponUpgrade, basicWeaponLbl);
        Label basicShieldLbl = new Label("500 Wood, 500 Leather: Improve soldiers");
        Button basicShieldUpgrade = new Button("Basic Shields");
        basicShieldHB = new HBox(10, basicShieldUpgrade, basicShieldLbl);
        Label horsebackRidingLbl = new Label("500 Food, 500 Wood: Build stables");
        Button horsebackRidingUpgrade = new Button("Horseback Riding");
        horsebackRidingHB = new HBox(10, horsebackRidingUpgrade, horsebackRidingLbl);
        Label wheetLbl = new Label("500 Wood, 500 Stone: Build mills");
        Button wheetUpgrade = new Button("The Wheet");
        wheetHB = new HBox(10, wheetUpgrade, wheetLbl);
        Label writingLbl = new Label("500 Skins: Increase cleric piety generation");
        Button writingUpgrade = new Button("Writing");
        writingHB = new HBox(10, writingUpgrade, writingLbl);

        //Purchased
        Label purchases = new Label("Purchased");
        purchasedVB = new VBox(10, purchases);

        upgradesVB = new VBox(15, skinUpgrHB, harvestUpgrHB, prospectHB, masonaryHB);

        TabPane tabPane = new TabPane();
        tabPane.setPrefHeight(1250);
        Tab buildingsTab = new Tab("Buildings");
        buildingsTab.setClosable(false);
        buildingsTab.setContent(buildingTabs);
        Tab upgradesTab = new Tab("Upgrades");
        upgradesTab.setClosable(false);
        upgradesTab.setContent(upgradesVB);
        tabPane.getTabs().addAll(buildingsTab, upgradesTab);

        VBox leftSide = new VBox(10, basicResVB, specResHB, tabPane);
        leftSide.setPadding(new Insets(20));
        leftSide.setPrefHeight(1250);


        //Right Side

        //Jobs Section
        unempl = new Label("Unemployed: " + game.getUnemplCnt());
        farmers = new Label("Farmers:               " + game.getFarmerCnt());
        farmers.setPrefWidth(150);
        woodCutters = new Label("Woodcutters:       " + game.getWoodCuttersCnt());
        woodCutters.setPrefWidth(150);
        miners = new Label("Miners:                 " + game.getMinersCnt());
        tanners = new Label("Tanners: " + game.getTanners()+ " Converts skin to leather");
        blacksmiths = new Label("Blacksmiths: " + game.getBlacksmiths()+ " Converts ore to metal");
        apothecaries = new Label("Apothecaries: " + game.getApothecary()+ " Cure sick workers");
        clerics = new Label("Clerics: " + game.getCleric() + " Cure sick workers");
        soldiers = new Label("Soldiers: " + game.getSoldiers() + " 10 metal, 10 leather: Protect from attack");
        miners.setPrefWidth(150);
        Button farmPlus = new Button(">");
        farmPlus.setOnAction((ActionEvent event) -> {
            if(game.getUnemplCnt() >= 1)
            {
                game.setUnemplCnt(game.getUnemplCnt()-1);
                unempl.setText("Unemployed: " + game.getUnemplCnt());
                game.setFarmerCnt(game.getFarmerCnt()+1);
                farmers.setText("Farmers: " + game.getFarmerCnt());
            }
            if(game.getFarmerCnt() != 0)
            {
                game.setFoodProdTime((game.getFarmerCnt()*1.2)+game.getWorkerEat());
                foodProd.setText(String.format("%.1f", game.getFoodProdTime()) + "/s");
            }
        });

        Button farmMinus = new Button("<");
        farmMinus.setOnAction((ActionEvent event) -> {
            if(game.getFarmerCnt() >= 1)
            {
                game.setUnemplCnt(game.getUnemplCnt()+1);
                unempl.setText("Unemployed: " + game.getUnemplCnt());
                game.setFarmerCnt(game.getFarmerCnt()-1);
                farmers.setText("Farmers: " + game.getFarmerCnt());
            }
            if(game.getFarmerCnt() >= 0)
            {
                game.setFoodProdTime(game.getFarmerCnt()*1.2+game.getWorkerEat());
                foodProd.setText(String.format("%.1f", game.getFoodProdTime()) + "/s");
            }
        });
        HBox farmerHB = new HBox(15, farmMinus, farmers, farmPlus);
        Button woodPlus = new Button(">");
        woodPlus.setOnAction((ActionEvent event) -> {
            if(game.getUnemplCnt() >= 1)
            {
                game.setUnemplCnt(game.getUnemplCnt()-1);
                unempl.setText("Unemployed: " + game.getUnemplCnt());
                game.setWoodCuttersCnt(game.getWoodCuttersCnt()+1);
                woodCutters.setText("Woodcutters: " + game.getWoodCuttersCnt());
            }
            if(game.getWoodCuttersCnt() != 0)
            {
                game.setWoodProdTime((game.getWoodCuttersCnt()*.5));
                woodProd.setText(String.format("%.1f", game.getWoodProdTime()) + "/s");
            }
        });
        Button woodMinus = new Button("<");
        woodMinus.setOnAction((ActionEvent event) -> {
            if(game.getWoodCuttersCnt() >= 1)
            {
                game.setUnemplCnt(game.getUnemplCnt()+1);
                unempl.setText("Unemployed: " + game.getUnemplCnt());
                game.setWoodCuttersCnt(game.getWoodCuttersCnt()-1);
                woodCutters.setText("Woodcutters: " + game.getWoodCuttersCnt());
            }
            if(game.getWoodCuttersCnt() != 0)
            {
                game.setWoodProdTime((game.getWoodCuttersCnt()*.5));
                woodProd.setText(String.format("%.1f", game.getWoodProdTime()) + "/s");
            }
        });
        HBox woodCutterHB = new HBox(15, woodMinus, woodCutters, woodPlus);
        Button minePlus = new Button(">");
        minePlus.setOnAction((ActionEvent event) -> {
            if(game.getUnemplCnt() >= 1)
            {
                game.setUnemplCnt(game.getUnemplCnt()-1);
                unempl.setText("Unemployed: " + game.getUnemplCnt());
                game.setMinersCnt(game.getMinersCnt()+1);
                miners.setText("Miners: " + game.getMinersCnt());
            }
            if(game.getMinersCnt() != 0)
            {
                game.setStoneProdTime((game.getMinersCnt()*.2));
                stoneProd.setText(String.format("%.1f", game.getStoneProdTime()) + "/s");
            }
        });
        Button mineMinus = new Button("<");
        mineMinus.setOnAction((ActionEvent event) -> {
            if(game.getMinersCnt() >= 1)
            {
                game.setUnemplCnt(game.getUnemplCnt()+1);
                unempl.setText("Unemployed: " + game.getUnemplCnt());
                game.setMinersCnt(game.getMinersCnt()-1);
                miners.setText("Miners: " + game.getMinersCnt());
            }
            if(game.getMinersCnt() != 0)
            {
                game.setStoneProdTime((game.getMinersCnt()*.2));
                stoneProd.setText(String.format("%.1f", game.getStoneProdTime()) + "/s");
            }
        });
        HBox minerHB = new HBox(15, mineMinus, miners, minePlus);
        Button tannerPlus = new Button(">");
        tannerPlus.setOnAction((ActionEvent event) -> {
            if(game.getUnemplCnt() >= 1)
            {
                game.setUnemplCnt(game.getUnemplCnt()-1);
                unempl.setText("Unemployed: " + game.getUnemplCnt());
                game.setTanners(game.getTanners()+1);
                tanners.setText("Tanners: " + game.getTanners()+ " Converts skin to leather");
            }
            if(game.getTanners()!= 0)
            {
                game.setLeatherProdTime((game.getTanners()*1));
            }
        });
        Button tannerMinus = new Button("<");
        tannerMinus.setOnAction((ActionEvent event) -> {
            if(game.getTanners()>= 1)
            {
                game.setUnemplCnt(game.getUnemplCnt()+1);
                unempl.setText("Unemployed: " + game.getUnemplCnt());
                game.setTanners(game.getTanners()-1);
                tanners.setText("Tanners: " + game.getTanners() + " Converts skin to leather");
            }
            if(game.getTanners() != 0)
            {
                game.setLeatherProdTime((game.getTanners()*1));
            }
        });
        tannersHB = new HBox(15, tannerMinus, tanners, tannerPlus);
        Button blacksmithPlus = new Button(">");
        blacksmithPlus.setOnAction((ActionEvent event) -> {
            if(game.getUnemplCnt() >= 1)
            {
                game.setUnemplCnt(game.getUnemplCnt()-1);
                unempl.setText("Unemployed: " + game.getUnemplCnt());
                game.setBlacksmiths(game.getBlacksmiths()+1);
                blacksmiths.setText("Blacksmiths: " + game.getBlacksmiths()+ " Converts ore to metal");
            }
            if(game.getBlacksmiths()!= 0)
            {
                game.setMetalProdTime((game.getBlacksmiths()*1));
            }
        });
        Button blacksmithsMinus = new Button("<");
        blacksmithsMinus.setOnAction((ActionEvent event) -> {
            if(game.getBlacksmiths()>= 1)
            {
                game.setUnemplCnt(game.getUnemplCnt()+1);
                unempl.setText("Unemployed: " + game.getUnemplCnt());
                game.setBlacksmiths(game.getBlacksmiths()-1);
                blacksmiths.setText("Blacksmiths: " + game.getBlacksmiths()+ " Converts ore to metal");
            }
            if(game.getBlacksmiths() != 0)
            {
                game.setMetalProdTime((game.getBlacksmiths()*1));
            }
        });
        blacksmithsHB = new HBox(15, blacksmithsMinus, blacksmiths, blacksmithPlus);
        Button apothecariesPlus = new Button(">");
        apothecariesPlus.setOnAction((ActionEvent event) -> {
            if(game.getUnemplCnt() >= 1)
            {
                game.setUnemplCnt(game.getUnemplCnt()-1);
                unempl.setText("Unemployed: " + game.getUnemplCnt());
                game.setApothecary(game.getApothecary()+1);
                apothecaries.setText("Apothecaries: " + game.getApothecary()+ " Cure sick workers");
            }
//            if(game.getApothecary()!= 0)
//            {
//                game.S((game.getBlacksmiths()*1));
//            }
        });
        Button apothecariesMinus = new Button("<");
        apothecariesMinus.setOnAction((ActionEvent event) -> {
            if(game.getApothecary()>= 1)
            {
                game.setUnemplCnt(game.getUnemplCnt()+1);
                unempl.setText("Unemployed: " + game.getUnemplCnt());
                game.setApothecary(game.getApothecary()-1);
                apothecaries.setText("Apothecaries: " + game.getApothecary()+ " Cure sick workers");
            }
//            if(game.getBlacksmiths() != 0)
//            {
//                game.setMetalProdTime((game.getBlacksmiths()*1));
//            }
        });
        apothecariesHB = new HBox(apothecariesMinus, apothecaries, apothecariesPlus);
        Button clericsPlus = new Button(">");
        clericsPlus.setOnAction((ActionEvent event) -> {
            if(game.getUnemplCnt() >= 1)
            {
                game.setUnemplCnt(game.getUnemplCnt()-1);
                unempl.setText("Unemployed: " + game.getUnemplCnt());
                game.setCleric(game.getCleric()+1);
                clerics.setText("Clerics: " + game.getCleric() + " Generate Piety, buy corpses");
            }
            if(game.getCleric()!= 0)
            {
                game.setPietyProdTime((game.getCleric()*1));
            }
        });
        Button clericsMinus = new Button("<");
        clericsMinus.setOnAction((ActionEvent event) -> {
            if(game.getApothecary()>= 1)
            {
                game.setUnemplCnt(game.getUnemplCnt()+1);
                unempl.setText("Unemployed: " + game.getUnemplCnt());
                game.setCleric(game.getCleric()-1);
                clerics.setText("Clerics: " + game.getCleric() + " Cure sick workers");
            }
            if(game.getCleric() != 0)
            {
                game.setPietyProdTime((game.getCleric()*1));
            }
        });
        clericsHB = new HBox(clericsMinus, clerics, clericsPlus);
        Button soldiersPlus = new Button(">");
        soldiersPlus.setOnAction((ActionEvent event) -> {
            if(game.getUnemplCnt() >= 1 && game.getMetalCnt() >= 10 && game.getLeatherCnt() >= 10)
            {
                game.setUnemplCnt(game.getUnemplCnt()-1);
                unempl.setText("Unemployed: " + game.getUnemplCnt());
                game.setMetalCnt(game.getMetalCnt()-10);
                metal.setText("Metal: " + game.getMetalCnt());
                game.setLeatherCnt(game.getLeatherCnt()-10);
                leather.setText("Leather: " + game.getLeatherCnt());
                game.setSoldiers(game.getSoldiers()+1);
                soldiers.setText("Soldiers: " + game.getSoldiers() + " 10 metal, 10 leather: Protect from attack");
            }
//            if(game.getCleric()!= 0)
//            {
//                game.setPietyProdTime((game.getCleric()*1));
//            }
        });
        Button soldiersMinus = new Button("<");
        soldiersMinus.setOnAction((ActionEvent event) -> {
            if(game.getSoldiers() >= 1)
            {
                game.setUnemplCnt(game.getUnemplCnt()+1);
                unempl.setText("Unemployed: " + game.getUnemplCnt());
                game.setSoldiers(game.getSoldiers()-1);
                soldiers.setText("Soldiers: " + game.getSoldiers() + " 10 metal, 10 leather: Protect from attack");
            }
//            if(game.getCleric() != 0)
//            {
//                game.setPietyProdTime((game.getCleric()*1));
//            }
        });
        soldiersHB = new HBox(soldiersMinus, soldiers, soldiersPlus);
        jobsVB = new VBox(15, unempl, farmerHB, woodCutterHB, minerHB);
        jobsVB.setPadding(new Insets(10));

        //Population Section
        Label popLbl = new Label("Population");
        currPop = new Label("Current Population: " + game.getCurrPopCnt());
        maxPop = new Label("Maximum Population: " + game.getMaxPopCnt());
        Label createWorkLbl = new Label("20 food: Create a new worker");
        Button createWorker = new Button("Create Worker");
        createWorker.setOnAction(new CreateWorkerButton());

        //Stats section
        Label stats = new Label("Stats");
        resourcesClicked = new Label("Resources Clicked: " + game.getButtonClicked());
        totalLand = new Label("Total Land: " + game.getTotalLand());
        freeLand = new Label("Free Land: " + game.getFreeLand());
        totalBuildings = new Label("Total Buildings: " + game.getTotalBuildingd());
        VBox statsVB = new VBox(10, stats, resourcesClicked, totalLand, totalBuildings, freeLand);

        //Incrementing Food
        do {
            int delay = 5000; // delay for 5 sec.
            int period = 1000; // repeat every sec.
            Timer timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask()
            {
                @Override
                public void run()
                {
                    Platform.runLater(() -> {
                        if(game.getFoodCnt() < 0)
                        {
                            foodCount.setText("Food: 0");
                        } else if (game.getFoodCnt() >= game.getMaxFoodStrge())
                        {
                            foodCount.setText("Food: Max");
                        } else {
                            game.setFoodCnt(game.getFoodCnt() + game.getFoodProdTime());
                            foodCount.setText("Food: " + String.format("%.0f", game.getFoodCnt()));
                            if (game.isSkinUpgrade() == true && game.getFarmerCnt() > 0)
                            {
                                Random skinRan = new Random();
                                int ranNum = skinRan.nextInt(4);
                                if(ranNum == 1){
                                    game.setSkinCnt(game.getSkinCnt()+1);
                                    skins.setText("Skins: " + game.getSkinCnt());
                                }
                            }
                        }
                    });
                }
            }, delay, period);
        } while(game.getCurrPopCnt() != 0);

        //Incremeting Wood
        do {
            int delay = 5000; // delay for 5 sec.
            int period = 1000; // repeat every sec.
            Timer timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask()
            {
                @Override
                public void run()
                {
                    Platform.runLater(() -> {
                        if(game.getWoodCnt() < 0)
                        {
                            woodCount.setText("Wood: 0");
                        } else if (game.getWoodCnt() >= game.getMaxWoodStrge())
                        {
                            woodCount.setText("Wood: Max");
                        } else {
                            game.setWoodCnt(game.getWoodCnt() + game.getWoodProdTime());
                            woodCount.setText("Wood: " + String.format("%.0f", game.getWoodCnt()));
                            if (game.isHarvestUpgrade() == true && game.getWoodCuttersCnt() > 0)
                            {
                                Random herbRan = new Random();
                                int ranNum = herbRan.nextInt(4);
                                if(ranNum == 1){
                                    game.setHerbCnt(game.getHerbCnt()+1);
                                    herbs.setText("Herbs: " + game.getHerbCnt());
                                }
                            }
                        }
                    });
                }
            }, delay, period);
        } while(game.getWoodCuttersCnt() != 0);

        //Incrementing Stone
        do {
            int delay = 5000; // delay for 5 sec.
            int period = 1000; // repeat every sec.
            Timer timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask()
            {
                @Override
                public void run()
                {
                    Platform.runLater(() -> {
                        if(game.getStoneCnt() < 0)
                        {
                            stoneCount.setText("Stone: 0");
                        } else if (game.getStoneCnt() >= game.getMaxStoneStrge())
                        {
                            stoneCount.setText("Stone: Max");
                        } else {
                            game.setStoneCnt(game.getStoneCnt() + game.getStoneProdTime());
                            stoneCount.setText("Stone: " + String.format("%.0f", game.getStoneCnt()));
                            if (game.isProspectUpgrade() == true && game.getMinersCnt() > 0)
                            {
                                Random oresRan = new Random();
                                int ranNum = oresRan.nextInt(4);
                                if(ranNum == 1){
                                    game.setOreCnt(game.getOreCnt()+1);
                                    ores.setText("Ores: " + game.getOreCnt());
                                }
                            }
                        }
                    });
                }
            }, delay, period);
        } while(game.getMinersCnt() != 0);

        HBox createWrkHB = new HBox(10, createWorker, createWorkLbl);
        VBox popVB = new VBox(20, popLbl, currPop, maxPop, createWrkHB);
        VBox rightSide = new VBox(25, popVB, jobsVB, statsVB);
        rightSide.setPadding(new Insets(20));


        //Setting up scene
        ScrollPane sp = new ScrollPane();
        HBox mainHB = new HBox(30, leftSide, rightSide);
        sp.setContent(mainHB);
        sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        sp.setPrefSize(1250, 900);
        sp.getStyleClass().add("scroll-pane");
        VBox mainVB = new VBox(sp);
        mainVB.setPrefSize(1250, 900);
        Scene scene = new Scene(mainVB, 1250, 900);
        scene.getStylesheets().add("/com/example/resourceclick/theme.css");
        primaryStage.setTitle("Resource Click Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    /*
     *   Building Button Handlers
     */
    class FoodButton implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent event) {
            if(game.getFoodCnt() <= game.getMaxFoodStrge()-1) {
                game.setFoodCnt(game.getFoodCnt()+1);
                foodCount.setText("Food: " + String.format("%.0f", game.getFoodCnt()));
            } else {
                gathFood.setDisable(true);
            }
            Random skinRan = new Random();
            int ranNum = skinRan.nextInt(4);
            if(ranNum == 1){
                game.setSkinCnt(game.getSkinCnt()+1);
                skins.setText("Skins: " + game.getSkinCnt());
            }
            game.setButtonClicked(game.getButtonClicked()+1);
            resourcesClicked.setText("Resources Clicked: " + game.getButtonClicked());
        }
    }

    class StoneButton implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent event) {
            if(game.getStoneCnt() <= game.getMaxStoneStrge()-1) {
                game.setStoneCnt(game.getStoneCnt()+1);
                stoneCount.setText("Stone: " + String.format("%.0f", game.getStoneCnt()));
            } else {
                gathStone.setDisable(true);
            }
            Random oresRan = new Random();
            int ranNum = oresRan.nextInt(4);
            if(ranNum == 1){
                game.setOreCnt(game.getOreCnt()+1);
                ores.setText("Ores: " + game.getOreCnt());
            }
            game.setButtonClicked(game.getButtonClicked()+1);
            resourcesClicked.setText("Resources Clicked: " + game.getButtonClicked());
        }
    }

    class WoodButton implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent event) {
            if(game.getWoodCnt() <= game.getMaxWoodStrge()-1) {
                game.setWoodCnt(game.getWoodCnt()+1);
                woodCount.setText("Wood: " + String.format("%.0f", game.getWoodCnt()));
            } else {
                gathWood.setDisable(true);
            }
            Random woodRan = new Random();
            int ranNum = woodRan.nextInt(4);
            if(ranNum == 1){
                game.setHerbCnt(game.getHerbCnt()+1);
                herbs.setText("Herbs: " + game.getHerbCnt());
            }
            game.setButtonClicked(game.getButtonClicked()+1);
            resourcesClicked.setText("Resources Clicked: " + game.getButtonClicked());
        }
    }

    class tanneryButton implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent event) {
            if(game.getWoodCnt() >= 30 && game.getStoneCnt() >= 70 && game.getSkinCnt() >= 2)
            {
                game.setWoodCnt(game.getWoodCnt()-30);
                woodCount.setText("Wood: " + String.format("%.0f", game.getWoodCnt()));
                game.setStoneCnt(game.getStoneCnt()-70);
                stoneCount.setText("Stone: " + String.format("%.0f", game.getStoneCnt()));
                game.setSkinCnt(game.getSkinCnt()-2);
                skins.setText("Skins: " + game.getSkinCnt());
                game.setTanners(game.getTanners()+1);
                tanners.setText("Tanners: " + game.getTanners()+ " Converts skin to leather");
                jobsVB.getChildren().add(tannersHB);
                game.setFreeLand(game.getFreeLand()-1);
                freeLand.setText("Free Land: " + game.getFreeLand());
                game.setTotalBuildingd(game.getTotalBuildingd()+1);
                totalBuildings.setText("Total Buildings: " + game.getTotalBuildingd());
            }
        }
    }

    class smithsButton implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent event) {
            if(game.getWoodCnt() >= 30 && game.getStoneCnt() >= 70 && game.getOreCnt()>= 2)
            {
                game.setWoodCnt(game.getWoodCnt()-30);
                woodCount.setText("Wood: " + String.format("%.0f", game.getWoodCnt()));
                game.setStoneCnt(game.getStoneCnt()-70);
                stoneCount.setText("Stone: " + String.format("%.0f", game.getStoneCnt()));
                game.setOreCnt(game.getOreCnt()-2);
                ores.setText("Ores: " + game.getSkinCnt());
                game.setBlacksmiths(game.getBlacksmiths()+1);
                blacksmiths.setText("Blacksmiths: " + game.getBlacksmiths()+ " Converts ore to metal");
                jobsVB.getChildren().add(blacksmithsHB);
                game.setFreeLand(game.getFreeLand()-1);
                freeLand.setText("Free Land: " + game.getFreeLand());
                game.setTotalBuildingd(game.getTotalBuildingd()+1);
                totalBuildings.setText("Total Buildings: " + game.getTotalBuildingd());
            }
        }
    }

    class apothecaryButton implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent event) {
            if(game.getWoodCnt() >= 30 && game.getStoneCnt() >= 70 && game.getHerbCnt()>= 2)
            {
                game.setWoodCnt(game.getWoodCnt()-30);
                woodCount.setText("Wood: " + String.format("%.0f", game.getWoodCnt()));
                game.setStoneCnt(game.getStoneCnt()-70);
                stoneCount.setText("Stone: " + String.format("%.0f", game.getStoneCnt()));
                game.setHerbCnt(game.getHerbCnt()-2);
                herbs.setText("Herbs: " + game.getHerbCnt());
                game.setApothecary(game.getApothecary()+1);
                apothecaries.setText("Apothecaries: " + game.getApothecary()+ " Cure sick workers");
                jobsVB.getChildren().add(apothecariesHB);
                game.setFreeLand(game.getFreeLand()-1);
                freeLand.setText("Free Land: " + game.getFreeLand());
                game.setTotalBuildingd(game.getTotalBuildingd()+1);
                totalBuildings.setText("Total Buildings: " + game.getTotalBuildingd());
            }
        }
    }

    class templeButton implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent event) {
            if(game.getWoodCnt() >= 30 && game.getStoneCnt() >= 120 && game.getHerbCnt()>= 10)
            {
                game.setWoodCnt(game.getWoodCnt()-30);
                woodCount.setText("Wood: " + String.format("%.0f", game.getWoodCnt()));
                game.setStoneCnt(game.getStoneCnt()-120);
                stoneCount.setText("Stone: " + String.format("%.0f", game.getStoneCnt()));
                game.setHerbCnt(game.getHerbCnt()-10);
                herbs.setText("Herbs: " + game.getHerbCnt());
                game.setCleric(game.getCleric()+1);
                clerics.setText("Clerics: " + game.getCleric() + " Cure sick workers");
                jobsVB.getChildren().add(clericsHB);
                game.setFreeLand(game.getFreeLand()-1);
                freeLand.setText("Free Land: " + game.getFreeLand());
                game.setTotalBuildingd(game.getTotalBuildingd()+1);
                totalBuildings.setText("Total Buildings: " + game.getTotalBuildingd());
            }
        }
    }

    class barracksButton implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent event) {
            if(game.getFoodCnt() >= 20 && game.getWoodCnt() >= 60 && game.getStoneCnt() >= 120 && game.getMetalCnt() >= 10)
            {
                game.setFoodCnt(game.getFoodCnt()-20);
                foodCount.setText("Food: " + String.format("%.0f", game.getFoodCnt()));
                game.setWoodCnt(game.getWoodCnt()-60);
                woodCount.setText("Wood: " + String.format("%.0f", game.getWoodCnt()));
                game.setStoneCnt(game.getStoneCnt()-120);
                stoneCount.setText("Stone: " + String.format("%.0f", game.getStoneCnt()));
                game.setMetalCnt(game.getMetalCnt()-10);
                metal.setText("Metal: " + game.getMetalCnt());
                game.setSoldiers(game.getSoldiers()+1);
                soldiers.setText("Soldiers: " + game.getSoldiers() + " 10 metal, 10 leather: Protect from attack");
                game.setFreeLand(game.getFreeLand()-1);
                freeLand.setText("Free Land: " + game.getFreeLand());
                game.setTotalBuildingd(game.getTotalBuildingd()+1);
                totalBuildings.setText("Total Buildings: " + game.getTotalBuildingd());
            }
        }
    }

    /*
     *   Worker buttons
     */
    class CreateWorkerButton implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent event) {
            if(game.getMaxPopCnt() >= 1 && game.getFoodCnt() >= 20)
            {
                if (game.getCurrPopCnt() != game.getMaxPopCnt())
                {
                    game.setCurrPopCnt(game.getCurrPopCnt()+1);
                    currPop.setText("Current Population: " + game.getCurrPopCnt());
                    game.setUnemplCnt(game.getUnemplCnt()+1);
                    unempl.setText("Unemployed: " + game.getUnemplCnt());
                    game.setFoodCnt(game.getFoodCnt()-20);
                    foodCount.setText("Food: " + String.format("%.0f", game.getFoodCnt()));
                }
            }
            if(game.getCurrPopCnt() != 0)
            {
                game.setWorkerEat(game.getCurrPopCnt()*-1);
                game.setFoodProdTime((game.getFarmerCnt()*1.2)+game.getWorkerEat());
                foodProd.setText(String.format("%.1f", game.getFoodProdTime()) + "/s");
            }
        }
    }

    /*
     * Storage Buttons
     */
    class barnButton implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent event) {
            if(game.getWoodCnt() >= 100)
            {
                game.setBarnCnt(game.getBarnCnt()+1);
                barns.setText("Barns:       " + game.getBarnCnt() + "       100 wood: store +200 food");
                game.setWoodCnt(game.getWoodCnt()-100);
                woodCount.setText("Wood: " + game.getWoodCnt());
                game.setMaxFoodStrge(game.getMaxFoodStrge()+200);
                foodStorage.setText("Max Storage: " + game.getMaxFoodStrge());
                game.setFreeLand(game.getFreeLand()-1);
                freeLand.setText("Free Land: " + game.getFreeLand());
                game.setTotalBuildingd(game.getTotalBuildingd()+1);
                totalBuildings.setText("Total Buildings: " + game.getTotalBuildingd());
            }
        }
    }

    class woodStockPileButton implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent event) {
            if(game.getWoodCnt() >= 100)
            {
                game.setWoodStockPilesCnt(game.getWoodStockPilesCnt()+1);
                woodStockPiles.setText("Wood StockPiles:       " + game.getWoodStockPilesCnt() + "       100 wood: store +200 wood");
                game.setWoodCnt(game.getWoodCnt()-100);
                woodCount.setText("Wood: " + game.getWoodCnt());
                game.setMaxWoodStrge(game.getMaxWoodStrge()+200);
                woodStorage.setText("Max Storage: " + game.getMaxWoodStrge());
                game.setFreeLand(game.getFreeLand()-1);
                freeLand.setText("Free Land: " + game.getFreeLand());
                game.setTotalBuildingd(game.getTotalBuildingd()+1);
                totalBuildings.setText("Total Buildings: " + game.getTotalBuildingd());
            }
        }
    }

    class stoneStockPileButton implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent event) {
            if(game.getWoodCnt() >= 100)
            {
                game.setStoneStockPilesCnt(game.getStoneStockPilesCnt()+1);
                stoneStockPiles.setText("Stone StockPiles:       " + game.getStoneStockPilesCnt() + "       100 wood: store +200 stone");
                game.setWoodCnt(game.getWoodCnt()-100);
                woodCount.setText("Wood: " + game.getWoodCnt());
                game.setMaxStoneStrge(game.getMaxStoneStrge()+200);
                stoneStorage.setText("Max Storage: " + game.getMaxStoneStrge());
                game.setFreeLand(game.getFreeLand()-1);
                freeLand.setText("Free Land: " + game.getFreeLand());
                game.setTotalBuildingd(game.getTotalBuildingd()+1);
                totalBuildings.setText("Total Buildings: " + game.getTotalBuildingd());
            }
        }
    }

    class skinUpgradeButton implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent event)
        {
            if(game.getSkinCnt() >= 10)
            {
                game.setSkinUpgrade(true);
                game.setSkinCnt(game.getSkinCnt()-10);
                skins.setText("Skins: " + game.getSkinCnt());
                Label skinUpgraded = new Label("Skinning: Farmers can collect skins");
                purchasedVB.getChildren().add(skinUpgraded);
                upgradesVB.getChildren().remove(skinUpgrHB);
                upgradesVB.getChildren().add(purchasedVB);
            }
        }
    }

    class harvestUpgradeButton implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent event)
        {
            if(game.getHerbCnt() >= 10)
            {
                game.setHarvestUpgrade(true);
                game.setHerbCnt(game.getHerbCnt()-10);
                herbs.setText("Herbs: " + game.getHerbCnt());
                Label harvestUpgraded = new Label("Harvesting: Woodcutters can collect herbs");
                purchasedVB.getChildren().add(harvestUpgraded);
                upgradesVB.getChildren().remove(harvestUpgrHB);
            }
        }
    }

    class prospectUpgradeButton implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent event)
        {
            if(game.getOreCnt() >= 10)
            {
                game.setProspectUpgrade(true);
                game.setOreCnt(game.getOreCnt()-10);
                ores.setText("Ores: " + game.getOreCnt());
                Label prospectUpgraded = new Label("Prospecting: Miners can collect ores");
                purchasedVB.getChildren().add(prospectUpgraded);
                upgradesVB.getChildren().remove(prospectHB);
            }
        }
    }

    class masonaryUpgradeButton implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent event) {
            if(game.getWoodCnt() >= 100 && game.getStoneCnt() >= 100)
            {
                game.setWoodCnt(game.getWoodCnt()-100);
                woodCount.setText("Wood: " + String.format("%.0f", game.getWoodCnt()));
                game.setStoneCnt(game.getStoneCnt()-100);
                stoneCount.setText("Stone :" + String.format("%.0f", game.getStoneCnt()));
                upgradesVB.getChildren().removeAll(masonaryHB, purchasedVB);
                upgradesVB.getChildren().addAll(domesticationHB, ploughSharesHB, irrigationHB, constructionHB, granariesHB, basicWeaponHB, basicShieldHB, horsebackRidingHB, wheetHB, writingHB, purchasedVB);
                Label masonaryPurch = new Label("Masonary: Unlock more buildings and upgrades");
                purchasedVB.getChildren().add(masonaryPurch);
                buildingTabs.getChildren().addAll(firstUpgrBuildings);
            }
        }
    }
}
