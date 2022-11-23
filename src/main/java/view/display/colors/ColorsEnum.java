package view.display.colors;

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
    DARK_GRAYBLUE {
        @Override
        public Color getColor() {
            return new Color(19, 63, 84);
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
    },
    BLACK_DARK {
        @Override
        public Color getColor() {
            return new Color(21, 21, 21);
        }
    },
    BLACK_ONE {
        @Override
        public Color getColor() {
            return new Color(4, 28, 50);
        }
    },
    NAVY_BLACK {
        @Override
        public Color getColor() {
            return new Color(4, 41, 58);
        }
    },
    NAVY_LIGHT {
        @Override
        public Color getColor() {
            return new Color(6, 70, 99);
        }
    },
    NAVY_EXLIGHT {
        @Override
        public Color getColor() {
            return new Color(41, 117, 153);
        }
    },
    ARENA {
        @Override
        public Color getColor() {
            return new Color(236, 179, 101);
        }
    },
    PURPLE_DARK {
        @Override
        public Color getColor() {
            return new Color(48, 27, 63);
        }
    },
    PURPLE_LIGHT {
        @Override
        public Color getColor() {
            return new Color(60, 65, 92);
        }
    },
    GRAY_PURPLE {
        @Override
        public Color getColor() {
            return new Color(180, 165, 165);
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
