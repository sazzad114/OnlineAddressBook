package net.therap.dao;

import net.therap.domain.User;
import net.therap.domain.Vcard;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: sazzadur
 * Date: 6/27/12
 * Time: 9:19 AM
 * To change this template use File | Settings | File Templates.
 */
public interface VcardDao {

    public void saveVcard(Vcard vcard);

    public List<Vcard> getVcardListByUser(User user);

    public Vcard getVcardById(long vcardId);

    public void deleteVcardByUser(User user,Vcard vcard);

    public void updateVcardByUser(Vcard vcard);
}
