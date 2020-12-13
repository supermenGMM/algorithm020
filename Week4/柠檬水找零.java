class Solution {
    //柠檬水找零
    public boolean lemonadeChange(int[] bills) {
        //已有的钱和数量
        TreeMap<Integer,Integer> money = new TreeMap<Integer,Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] > 5) {//给的不是5快
                System.out.print("钱"+bills[i]+",map为"+money+";");
                boolean change = change(bills[i] - 5, money);
                System.out.println("钱"+bills[i]+",能否找零"+change+",map为"+money);
                if (!change) {
                    return false;
                }
            }
            //放到钱包
            money.put(bills[i], money.getOrDefault(bills[i], 0) + 1);
        }
        return true;
    }

     private boolean change(int changeMoney, TreeMap<Integer, Integer> money) {
        for (Map.Entry<Integer,Integer> entry : money.entrySet()) {
            if (entry.getKey() <= changeMoney&&entry.getValue()>=1) {//有零钱
                money.put(entry.getKey(), entry.getValue() - 1);
                int remainMon = changeMoney - entry.getKey();//剩余要兑换的钱
                if (remainMon == 0) {
                    return true;
                }else{
                    return change(remainMon, money);
                }
            }
        }
        return false;
    }
}