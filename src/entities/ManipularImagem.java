/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UTIL;


import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author marcelosiedler
 */
public class ManipularImagem {

    //Metodo para transforma a imagem e bytes
    public static byte[] getImgBytes(BufferedImage image) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ImageIO.write(image, "JPEG", baos);
        } catch (IOException ex) {
            //handle it here.... not implemented yet...
        }
        
        InputStream is = new ByteArrayInputStream(baos.toByteArray());
        
        return baos.toByteArray();
    }
    //Novo método para exibir imagem na tela
    //Recebe o label que queremos exibir E a imagem como array de bytes do banco
    public static void exibiImagemLabel(byte[] minhaimagem, javax.swing.JLabel label)
{
        //primeiro verifica se tem a imagem
        //se tem convert para inputstream que é o formato reconhecido pelo ImageIO
       
        if(minhaimagem!=null)
        {
            InputStream input = new ByteArrayInputStream(minhaimagem);
            try {
                BufferedImage imagem = ImageIO.read(input);
                label.setIcon(new ImageIcon(imagem));
            } catch (IOException ex) {
            }
            
        
        }
        else
        {
            label.setIcon(null);
            
        }

}
}
