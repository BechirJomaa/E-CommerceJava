/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utile;

import DAO.PubliciteDAO;
import Entity.Publicite;
import com.alee.extended.image.WebImage;
import com.alee.extended.transition.ComponentTransition;
import java.awt.Image;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author gafsi
 */
public class AnimationThread extends Thread {

    private ComponentTransition componentTransition;
    private WebImage image1 = new WebImage();
    private PubliciteDAO pubDAO = new PubliciteDAO();
    private List<Publicite> pubs = new ArrayList<>();
    private JPanel p;
    private JLabel lNom;
    private JLabel lDate;
    private JLabel lType;
    private int pubId;
    

    public AnimationThread(ComponentTransition componentTransition,JLabel lNom,JLabel lDate,JLabel lType) {
        this.componentTransition = componentTransition;
        this.p = p;
        this.lNom=lNom;
        this.lDate=lDate;
        this.lType=lType;
                
        pubs = pubDAO.findAll();

    }
    public int getPubId(){
        return pubId;
    }
    
    public void run() {
        if (pubs.size() > 0) {
            int i = 0;
            pubId=pubs.get(i).getId();
            String imagePath = "src\\com\\images\\" + pubs.get(i).getId() + ".png";
            ImageIcon icon1 = new ImageIcon(new ImageIcon(imagePath).getImage().
                    getScaledInstance(270, 430, Image.SCALE_DEFAULT));
            image1 = new WebImage(icon1);
            componentTransition.performTransition(image1);
            detail(i);
            while (true) {
                i++;
                if (i < pubs.size()) {
                    pubId=pubs.get(i).getId();
                    imagePath = "src\\com\\images\\" + pubs.get(i).getId() + ".png";
                    icon1 = new ImageIcon(new ImageIcon(imagePath).getImage().
                            getScaledInstance(270, 430, Image.SCALE_DEFAULT));
                    image1 = new WebImage(icon1);
                    componentTransition.performTransition(image1);
                    detail(i);

                } else {
                    i = 0;
                    pubId=pubs.get(i).getId();
                    imagePath = "src\\com\\images\\" + pubs.get(i).getId() + ".png";
                    icon1 = new ImageIcon(new ImageIcon(imagePath).getImage().
                            getScaledInstance(270, 280, Image.SCALE_DEFAULT));
                    image1 = new WebImage(icon1);
                    componentTransition.performTransition(image1);
                    detail(i);
                }
                try {
                    sleep(5000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }

    }

    private void detail(int i) {
        lDate.setText(""+pubs.get(i).getDate());
        lNom.setText(pubs.get(i).getLieu());
        lType.setText(pubs.get(i).getType());

    }
     //706 040 255
    //38g9qg

}
