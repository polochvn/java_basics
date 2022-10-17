package main;

import main.model.Deal;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Storage {

    private static AtomicInteger currentId = new AtomicInteger(0);
    private static Map<Integer, Deal> deals = Collections.synchronizedMap(new HashMap<>());

    public static List<Deal> getAllDeals() {

        ArrayList<Deal> list = new ArrayList<>();
        list.addAll(deals.values());
        return list;
    }

    public static Deal getDeal(int dealId) {

        if (deals.containsKey(dealId)) {
            return deals.get(dealId);
        }
        return null;
    }

    public static int addDeal(Deal deal) {

        int id = currentId.incrementAndGet();
        deal.setId(id);
        deals.put(id, deal);
        return id;
    }

    public static void updateDeals(List<Deal> list) {
            for (Deal deal : list) {
                if(deals.containsKey(deal.getId())) {
                    deals.remove(deal.getId());
                    deals.put(deal.getId(), deal);
                }
            }
    }

    public static Deal updateDeal(int id, Deal newDeal) {
            Deal deal = deals.get(id);
            deal.setNumberSheets(newDeal.getNumberSheets());
            deal.setLastDate(newDeal.getLastDate());
            deal.setName(newDeal.getName());
            deals.remove(id);
            deals.put(id, deal);
            return deal;
    }

    public static void removeDeals() {
        deals.clear();
        currentId = new AtomicInteger(0);
    }

    public static Deal removeDeal(int dealId) {
        if (deals.containsKey(dealId)) {
            deals.remove(dealId);
            return deals.get(dealId);
        }
        return null;

    }
}
