package nv.thuong.model;

import java.io.Serializable;

public class CacSo implements Serializable {
    private String txtA;
    private String txtB;
    private String txtKQ;

    public CacSo() {
    }

    public CacSo(String txtA, String txtB, String txtKQ) {
        this.txtA = txtA;
        this.txtB = txtB;
        this.txtKQ = txtKQ;
    }

    public String getTxtA() {
        return txtA;
    }

    public void setTxtA(String txtA) {
        this.txtA = txtA;
    }

    public String getTxtB() {
        return txtB;
    }

    public void setTxtB(String txtB) {
        this.txtB = txtB;
    }

    public String getTxtKQ() {
        return txtKQ;
    }

    public void setTxtKQ(String txtKQ) {
        this.txtKQ = txtKQ;
    }
}
