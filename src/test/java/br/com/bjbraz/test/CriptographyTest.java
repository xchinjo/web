package br.com.bjbraz.test;

import static org.junit.Assert.assertTrue;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;
import org.junit.Test;

public class CriptographyTest {
	
    private static final String API_KEY = "36BE5D3F-61DD-4836-AE21-39D7A8A686D6";
    private static final String CPF = "27527461560";
	
	@Test
	public void criptoGrafic() throws Exception {
		String resultadoEsperado = "69e16461d02d56f4b49307562558e3cb0acbae8975b1c420b7871c289b5c9225";
		String valoresHash = "11975132641"+"86543582626";
		String hash = encode(API_KEY, valoresHash);
		assertTrue("Validar a criptografia HMAC ", resultadoEsperado.equals(hash));
	}
	
	public static String encode(String key, String data) throws Exception {
		  Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
		  SecretKeySpec secret_key = new SecretKeySpec(key.getBytes("UTF-8"), "HmacSHA256");
		  sha256_HMAC.init(secret_key);

		  return Hex.encodeHexString(sha256_HMAC.doFinal(data.getBytes("UTF-8")));
	}

}
