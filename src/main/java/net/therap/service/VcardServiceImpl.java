package net.therap.service;

import net.therap.dao.UserDao;
import net.therap.dao.VcardDao;
import net.therap.domain.ImportFileCommand;
import net.therap.domain.User;
import net.therap.domain.Vcard;
import net.therap.utills.VcardUtills;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: sazzadur
 * Date: 6/27/12
 * Time: 9:21 AM
 * To change this template use File | Settings | File Templates.
 */
public class VcardServiceImpl implements VcardService{

    private VcardDao vcardDao;
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public VcardDao getVcardDao() {
        return vcardDao;
    }

    public void setVcardDao(VcardDao vcardDao) {
        this.vcardDao = vcardDao;
    }


    public Vcard getVcardById(long vcardId) {
       return vcardDao.getVcardById(vcardId);
    }

    public List<Vcard> getVcardListByUser(User user) {
        return vcardDao.getVcardListByUser(user);
    }

    public void saveVcard(Vcard vcard){

      vcard.setLastRevision(new Date());
      vcard.setVcardVersion("4.0");
      vcard.getAddressList().get(0).setVcard(vcard);
      vcard.getPhoneNoList().get(0).setVcard(vcard);
      vcardDao.saveVcard(vcard);

    }

    public void deleteVcardByUser(User user,long vcardId){
        Vcard vcard = vcardDao.getVcardById(vcardId);
        vcardDao.deleteVcardByUser(user,vcard);
    }

    public List<Vcard> searchVcardByName(String name, User user) {
       return vcardDao.searchVcardByName(name,user);
    }

    public void importVcardFromFile(ImportFileCommand command,User user) throws IOException {
        byte [] vcardBytes = command.getFile().getBytes();
        Vcard vcard = VcardUtills.byteArrayToVcard(vcardBytes);
        user = userDao.getUserById(user.getUserId());
        user.getVcardList().add(vcard);
        vcard.setUser(user);

        vcardDao.saveVcard(vcard);
    }

    public void updateVcardByUser(Vcard vcard){
        vcardDao.updateVcardByUser(vcard);
    }
}
