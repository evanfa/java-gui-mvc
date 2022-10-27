package data.pass.colors;

import java.awt.*;

public enum ColorsEnum implements Colorful {
    TC_BLUE {
        @Override
        public Color getColor() {
            return new Color(35, 124, 193);
        }
    },
    TC_GREEN {
        @Override
        public Color getColor() {
            return new Color(121, 155, 62);
        }
    },
    DARK_GRAY {
        @Override
        public Color getColor() {
            return new Color(76, 76, 76);
        }
    },
    BLUE_TARO {
        @Override
        public Color getColor() {
            return new Color(10, 37, 69);
        }
    },
    GREEN_EXCEL {
        @Override
        public Color getColor() {
            return new Color(85, 146, 29);
        }
    },
    BLUE_FOLDER {
        @Override
        public Color getColor() {
            return new Color(30, 160, 207);
        }
    },
    BLUE_TEMPER {
        @Override
        public Color getColor() {
            return new Color(4, 116, 149);
        }
    },
    GRAY_LIGHT {
        @Override
        public Color getColor() {
            return new Color(163, 175, 177);
        }
    },
    ORANGE_SHOCK {
        @Override
        public Color getColor() {
            return new Color(255, 96, 0);
        }
    };

    @Override
    public Color getColor() {
        return new Color(0, 0, 0);
    }

    @Override
    public String toString() {
        return String.valueOf(getColor());
    }
}
