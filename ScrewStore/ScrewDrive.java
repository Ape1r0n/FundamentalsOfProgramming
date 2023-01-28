package ScrewStore;

public enum ScrewDrive{
    SlotDrive{
        public String toString(){
            return "schlitz";
        }
    },Cross{
        public String toString(){
            return "kreuzschlitz";
        }
    }, Hex{
        public String toString(){
            return "sechskant";
        }
    }, Torx{
        public String toString(){
            return "torx";
        }
    };
    public abstract String toString();
}