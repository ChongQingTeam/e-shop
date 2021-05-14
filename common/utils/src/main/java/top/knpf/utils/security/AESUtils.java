package top.knpf.utils.security;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AESUtils {

    private static final String aesKey = "H9bhcblkwCslr7cK";
//    private static final String aesIv = "4PEwaZGcu8AVRUU2";
    private static SecretKeySpec keySpec = new SecretKeySpec(aesKey.getBytes(), "AES");
//    private static IvParameterSpec iv = new IvParameterSpec(aesIv.getBytes());
    //算法
    private static final String ALGORITHMSTR = "AES/ECB/PKCS5Padding";



    public static byte[] encrypt(byte[] data) {
        byte[] result = null;
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance(ALGORITHMSTR);
            cipher.init(Cipher.ENCRYPT_MODE, keySpec);
            result = cipher.doFinal(data);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public static String decrypt(String secret) {
        byte[] result = null;
        Cipher cipher = null;
        try {
            //IvParameterSpec ivParameterSpec = getIv();
            cipher = Cipher.getInstance(ALGORITHMSTR);
            cipher.init(Cipher.DECRYPT_MODE, keySpec);
            byte[] hexBytes = hexStringToBytes(secret);
            byte[] plainBytes = cipher.doFinal(hexBytes);
            return new String(plainBytes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 将16进制字符串装换为byte数组
     * @param hexString
     * @return
     */
    public static byte[] hexStringToBytes(String hexString) {
        hexString = hexString.toUpperCase();
        int length = hexString.length() / 2;
        char[] hexChars = hexString.toCharArray();
        byte[] b = new byte[length];
        for (int i = 0; i < length; i++) {
            int pos = i * 2;
            b[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
        }
        return b;
    }

    private static byte charToByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }
}
