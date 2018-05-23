import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

public class AsymetricKey {

    public static void main(String[] args) {

        try{
            // Obtener la instancia asignandole el algoritmo que vamos a utilizar
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(512);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();

            // Obtener clave publica
            PublicKey publicKey = keyPair.getPublic();
            // Obtener clave privada
            PrivateKey privateKey = keyPair.getPrivate();

            String mensaje = "Hola mundo";
            byte[] mensajeBytes = mensaje.getBytes();

            // Encriptacion con clave publica
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            byte[] mensajeEncriptadoBytes = cipher.doFinal(mensajeBytes);

            System.out.println("Mensaje original: "+ new String(mensajeBytes));
            System.out.println("Mensaje encriptado: "+new String(mensajeEncriptadoBytes));

            // Desencriptacion con clave privada
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] mensajeDesencriptadoBytes = cipher.doFinal(mensajeEncriptadoBytes);

            System.out.println("Mensaje desencriptado: "+new String(mensajeDesencriptadoBytes));

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

}
