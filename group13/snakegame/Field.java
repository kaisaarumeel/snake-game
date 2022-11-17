package group13.snakegame;

public class Field {
        private final int height;
        private final int width;

        public Field(int height, int width){
            this.height = height;
            this.width = width;
        }

        public int getHeight(){
            return this.height;
        }
        public int getWidth(){return this.width;}
    }

