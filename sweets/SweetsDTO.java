package sweets;

import java.util.ArrayList;

public class SweetsDTO {

 private String productName;
 private int   productPrice;
 private String shopName;
 private int   lot;
 private int   productId;
 private String productImg;
 private String stationName;


/* コンストラクタ */
 public SweetsDTO(){
 }

 public SweetsDTO(String productName, int productPrice, String shopName, int productId){
  this.productName = productName;
  this.productPrice = productPrice;
  this.shopName = shopName;
  this.productId = productId;
 }

 public SweetsDTO(String productName, int productPrice, String shopName, int lot, String productImg, String stationName){
  this.productName = productName;
  this.productPrice = productPrice;
  this.shopName = shopName;
  this.lot = lot;
  this.productImg = productImg;
  this.stationName = stationName;
 }

/* セッター＆ゲッター */
 public String getProductName() {
  return productName;
 }

 public void setProductName(String productName) {
  this.productName = productName;
 }

 public int getProductPrice() {
  return productPrice;
 }

 public void setProductPrice(int productPrice) {
  this.productPrice = productPrice;
 }


 public String getShopName() {
  return shopName;
 }

 public void setShopName(String shopName) {
  this.shopName = shopName;
 }

 public int getLot() {
  return lot;
 }

 public void setLot(int lot) {
  this.lot = lot;
 }

 public int getProductId() {
  return productId;
 }

 public void setProductId(int productId) {
  this.productId = productId;
 }

 public String getProductImg() {
  return productImg;
 }

 public void setProductImg(String productImg) {
  this.productImg = productImg;
 }

 public String getStationName() {
  return stationName;
 }

 public void setStationName(String stationName) {
  this.stationName = stationName;
 }

}