package database.commands;

import database.dao.PriorityQueueDAO;
import models.Address;
import models.Organization;

public class CountGreaterThanPostalAddress implements Command{
    private PriorityQueueDAO pqd = new PriorityQueueDAO();

    @Override
    public void execute(Object obj) {
        Address postalAddress = (Address) obj;
        int i = 0;
        try {
            for(Organization organization : pqd.getAll()){
                Address higherAddress = organization.getPostalAddress();
                if (postalAddress.compareTo(higherAddress) < 0){
                    i++;
                }
            }
            System.out.println("Количество элементов, превышающих postalAddress равно: " + i);
        } catch (NullPointerException e){
            System.err.println("Элемента, меньше заданного, не нашлось");
        }


    }
}
