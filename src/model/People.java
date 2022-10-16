package model;

public class People {
	private int id;
	private String ten;
	private int tuoi,gioitinh;
	private float luong,thuong,phat,tong;

    public People() {
    }

    public People(int id, String ten, int tuoi, int gioitinh, float luong, float thuong, float phat, float tong) {
        this.id = id;
        this.ten = ten;
        this.tuoi = tuoi;
        this.gioitinh = gioitinh;
        this.luong = luong;
        this.thuong = thuong;
        this.phat = phat;
        this.tong = tong;
    }
    

    public People(String ten, int tuoi, int gioitinh, float luong, float thuong, float phat, float tong) {
		super();
		this.ten = ten;
		this.tuoi = tuoi;
		this.gioitinh = gioitinh;
		this.luong = luong;
		this.thuong = thuong;
		this.phat = phat;
		this.tong = tong;
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public int getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(int gioitinh) {
        this.gioitinh = gioitinh;
    }

    public float getLuong() {
        return luong;
    }

    public void setLuong(float luong) {
        this.luong = luong;
    }

    public float getThuong() {
        return thuong;
    }

    public void setThuong(float thuong) {
        this.thuong = thuong;
    }

    public float getPhat() {
        return phat;
    }

    public void setPhat(float phat) {
        this.phat = phat;
    }

    public float getTong() {
        return tong;
    }

    public void setTong(float tong) {
        this.tong = tong;
    }

	@Override
	public String toString() {
		return "People [id=" + id + ", ten=" + ten + ", tuoi=" + tuoi + ", gioitinh=" + gioitinh + ", luong=" + luong
				+ ", thuong=" + thuong + ", phat=" + phat + ", tong=" + tong + "]";
	}
	
    
 
}