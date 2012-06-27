package net.therap.service;

import net.therap.domain.ImportFileCommand;
import net.therap.domain.User;
import net.therap.domain.Vcard;

import java.io.IOException;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: sazzadur
 * Date: 6/27/12
 * Time: 9:20 AM
 * To change this template use File | Settings | File Templates.
 */
public interface VcardService {
    public void saveVcard(Vcard vcard);

    public List<Vcard> getVcardListByUser(User user);

     public Vcard getVcardById(long vcardId);

    public void deleteVcardByUser(User user,long vcardId);

    public void updateVcardByUser(Vcard vcard);

    public void importVcardFromFile(ImportFileCommand command,User user) throws IOException;

    public List<Vcard> searchVcardByName(String name,User user);


}
