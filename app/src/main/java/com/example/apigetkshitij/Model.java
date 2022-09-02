package com.example.apigetkshitij;

public class Model {
    public int timepoint;
    public int cloudcover;
    public int seeing;
    public int transparency;
    public int lifted_index;
    public int rh2m;
    //Below the line could not be resolved....
    public Wind10m wind10m;
    public int temp2m;
    public String prec_type;


//    public Wind10m getWind() {
//        return wind;
//    }
//
//    public void setWind(Wind10m wind) {
//        this.wind = wind;
//    }

    public Model(int timepoint, int cloudcover, int seeing, int transparency,
                 int lifted_index, int rh2m, int temp2m, String prec_type, Wind10m wind10m)
    // Wind10m wind)
    {
        this.timepoint = timepoint;
        this.cloudcover = cloudcover;
        this.seeing = seeing;
        this.transparency = transparency;
        this.lifted_index = lifted_index;
        this.rh2m = rh2m;
        this.temp2m = temp2m;
        this.prec_type = prec_type;
        this.wind10m = wind10m;
    }

    public Wind10m getWind10m() {
        return wind10m;
    }

    public void setWind10m(Wind10m wind10m) {
        this.wind10m = wind10m;
    }

    public int getTimepoint() {
        return timepoint;
    }

    public void setTimepoint(int timepoint) {
        this.timepoint = timepoint;
    }

    public int getCloudcover() {
        return cloudcover;
    }

    public void setCloudcover(int cloudcover) {
        this.cloudcover = cloudcover;
    }

    public int getSeeing() {
        return seeing;
    }

    public void setSeeing(int seeing) {
        this.seeing = seeing;
    }

    public int getTransparency() {
        return transparency;
    }

    public void setTransparency(int transparency) {
        this.transparency = transparency;
    }

    public int getLifted_index() {
        return lifted_index;
    }

    public void setLifted_index(int lifted_index) {
        this.lifted_index = lifted_index;
    }

    public int getRh2m() {
        return rh2m;
    }

    public void setRh2m(int rh2m) {
        this.rh2m = rh2m;
    }

    public int getTemp2m() {
        return temp2m;
    }

    public void setTemp2m(int temp2m) {
        this.temp2m = temp2m;
    }

    public String getPrec_type() {
        return prec_type;
    }

    public void setPrec_type(String prec_type) {
        this.prec_type = prec_type;
    }

    //Second folder
    public class Root {
        public String product;
        public String init;

        public Root(String product, String init) {
            this.product = product;
            this.init = init;
        }

        public String getProduct() {
            return product;
        }

        public void setProduct(String product) {
            this.product = product;
        }

        public String getInit() {
            return init;
        }

        public void setInit(String init) {
            this.init = init;
        }
    }

    public static class Wind10m {
        public String direction;
        public int speed;

        public Wind10m(String direction, int speed) {
            this.direction = direction;
            this.speed = speed;
        }

        public String getDirection() {
            return direction;
        }

        public void setDirection(String direction) {
            this.direction = direction;
        }

        public int getSpeed() {
            return speed;
        }

        public void setSpeed(int speed) {
            this.speed = speed;
        }
    }
}

