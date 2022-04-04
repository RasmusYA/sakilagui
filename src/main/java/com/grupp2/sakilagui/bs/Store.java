package com.grupp2.sakilagui.bs;



import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "store")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    private int storeId;               //	tinyint(3) unsigned	NO	PRI		auto_increment

    @Column(name = "manager_staff_id")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Staff> managerStaffId;       //	tinyint(3) unsigned	NO	UNI

    // TODO Handle relation when Address is up
//    @Column(name = "address_id")
//    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private Address addressId;             //	smallint(5) unsigned	NO	MUL

    @Column(name = "last_update")
    private Date lastUpdate;            //	timestamp	NO		current_timestamp()	on update current_timestamp()

    public Store(){

    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public List<Staff> getManagerStaffId() {
        return managerStaffId;
    }

    public void setManagerStaffId(List<Staff> managerStaffId) {
        this.managerStaffId = managerStaffId;
    }

    // TODO Handle relation when Address is up
//    public Address getAddressId() {
//        return addressId;
//    }
//
//    public void setAddressId(Address addressId) {
//        this.addressId = addressId;
//    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
