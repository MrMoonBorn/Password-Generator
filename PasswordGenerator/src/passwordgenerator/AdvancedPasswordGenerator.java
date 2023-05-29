/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passwordgenerator;

/**
 *
 * @author onurd
 */
import java.security.SecureRandom;
import java.util.Random;

public class AdvancedPasswordGenerator {
  // Kullanılacak farklı karakter kümelerini temsil eden sabitler
  protected static final String LOWERCASE_ALPHABET = "abcdefghijklmnopqrstuvwxyz";
  protected static final String UPPERCASE_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  protected static final String NUMBERS = "0123456789";
  protected static final String SPECIAL_CHARACTERS = "!@#$%^&*()_+-=[]{}|,.<>/?";

  public static void main(String[] args) {
    // Rastgele sayılar üretmek için SecureRandom örneği oluştur
    SecureRandom random = new SecureRandom();
    // Karakter kümesi seçmek için Random örneği oluştur
    Random rnd = new Random();

    // Şifre metnini oluşturmak için StringBuilder kullan
    StringBuilder password = new StringBuilder();

    // 16 karakterlik rastgele şifre oluştur
    for (int i = 0; i < 16; i++) {
      // Rastgele bir karakter kümesi seç
      int r = rnd.nextInt(4);
      switch (r) {
        case 0:
          // Rastgele bir küçük harf ekle
          password.append(LOWERCASE_ALPHABET.charAt(random.nextInt(LOWERCASE_ALPHABET.length())));
          break;
        case 1:
          // Rastgele bir büyük harf ekle
          password.append(UPPERCASE_ALPHABET.charAt(random.nextInt(UPPERCASE_ALPHABET.length())));
          break;
        case 2:
          // Rastgele bir sayı ekle
          password.append(NUMBERS.charAt(random.nextInt(NUMBERS.length())));
          break;
        case 3:
          // Rastgele bir özel karakter ekle
          password.append(SPECIAL_CHARACTERS.charAt(random.nextInt(SPECIAL_CHARACTERS.length())));
          break;
      }
    }

    // Şifre metnini düzgün bir String'e dönüştür ve yazdır
    String passwordStr = password.toString();
    System.out.println("Oluşturulan şifre: " + passwordStr);
  }
}

