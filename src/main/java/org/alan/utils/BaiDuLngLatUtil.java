package org.alan.utils;

import java.util.HashMap;
import java.util.Map;

public class BaiDuLngLatUtil {

    /**
     * 获取当前用户一定距离以内的经纬度值
     * 单位米 return minLat
     * 最小经度 minLng
     * 最小纬度 maxLat
     * 最大经度 maxLng
     * 最大纬度 minLat
     */
    public static Map getAround(Double latitude, Double longitude, double radiusMile) {

        Map map = new HashMap();
        Double degree = (24901 * 1609) / 360.0;

        Double mpdLng = Double.parseDouble((degree * Math.cos(latitude * (Math.PI / 180))+"").replace("-", ""));
        Double dpmLng = 1 / mpdLng;
        Double radiusLng = dpmLng * radiusMile;
        Double minLng = longitude - radiusLng;
        Double maxLng = longitude + radiusLng;

        Double dpmLat = 1 / degree;
        Double radiusLat = dpmLat * radiusMile;
        Double minLat = latitude - radiusLat;
        Double maxLat = latitude + radiusLat;

        map.put("minLat", minLat+"");
        map.put("maxLat", maxLat+"");
        map.put("minLng", minLng+"");
        map.put("maxLng", maxLng+"");

        return map;
    }

    private static final Double PI = Math.PI;
    private static final Double PK = 180 / PI;

    /** a,b两点的距离
     * @param lat_a
     * @param lng_a
     * @param lat_b
     * @param lng_b
     * @param @return
     * @return double
     */
    public static double getDistanceFromTwoPoints(double lat_a, double lng_a, double lat_b, double lng_b) {

        double t1 = Math.cos(lat_a / PK) * Math.cos(lng_a / PK) * Math.cos(lat_b / PK) * Math.cos(lng_b / PK);
        double t2 = Math.cos(lat_a / PK) * Math.sin(lng_a / PK) * Math.cos(lat_b / PK) * Math.sin(lng_b / PK);
        double t3 = Math.sin(lat_a / PK) * Math.sin(lat_b / PK);
        double tt = Math.acos(t1 + t2 + t3);

        return 6366000 * tt;
    }

    public static void main(String[] args) {

        String hql = "from HotelInfo t where 1=1";
        String countHql = "select count(t) from HotelInfo t where 1=1";
        String query = hql;
        String count = countHql;
        double t = getDistanceFromTwoPoints(23.5539530, 114.8903920, 23.5554550, 114.8868890);
        System.out.println("getDistanceFromTwoPoints:" + (int)t);

        Map map = getAround(23.5539530, 114.8903920, 10000);

        System.out.println(map.get("minLat"));
        System.out.println(map.get("maxLat"));
        System.out.println(map.get("minLng"));
        System.out.println(map.get("maxLng"));
        System.out.println(map);
        query = query + "and t.lat > '" + map.get("minLat") + "'" + " and t.lat < '" +map.get("maxLat")+"'";
        System.out.println(query);
    }
}
