package com.limelight.binding.input;

import android.view.KeyEvent;

/**
 * Class to translate a Android key code into the codes GFE is expecting
 * @author Diego Waxemberg
 * @author Cameron Gutman
 */
public class KeyboardTranslator {
    
    /**
     * GFE's prefix for every key code
     */
    private static final short KEY_PREFIX = (short) 0x80;
    
    public static final int VK_0 = 48;
    public static final int VK_9 = 57;
    public static final int VK_A = 65;
    public static final int VK_Z = 90;
    public static final int VK_NUMPAD0 = 96;
    public static final int VK_BACK_SLASH = 92;
    public static final int VK_CAPS_LOCK = 20;
    public static final int VK_CLEAR = 12;
    public static final int VK_COMMA = 44;
    public static final int VK_BACK_SPACE = 8;
    public static final int VK_EQUALS = 61;
    public static final int VK_ESCAPE = 27;
    public static final int VK_F1 = 112;
    public static final int VK_END = 35;
    public static final int VK_HOME = 36;
    public static final int VK_NUM_LOCK = 144;
    public static final int VK_PAGE_UP = 33;
    public static final int VK_PAGE_DOWN = 34;
    public static final int VK_PLUS = 521;
    public static final int VK_CLOSE_BRACKET = 93;
    public static final int VK_SCROLL_LOCK = 145;
    public static final int VK_SEMICOLON = 59;
    public static final int VK_SLASH = 47;
    public static final int VK_SPACE = 32;
    public static final int VK_PRINTSCREEN = 154;
    public static final int VK_TAB = 9;
    public static final int VK_LEFT = 37;
    public static final int VK_RIGHT = 39;
    public static final int VK_UP = 38;
    public static final int VK_DOWN = 40;
    public static final int VK_BACK_QUOTE = 192;
    public static final int VK_QUOTE = 222;
    public static final int VK_PAUSE = 19;

    public static boolean needsShift(int keycode) {
        switch (keycode)
        {
            case KeyEvent.KEYCODE_AT:
            case KeyEvent.KEYCODE_POUND:
            case KeyEvent.KEYCODE_PLUS:
            case KeyEvent.KEYCODE_STAR:
                return true;

            default:
                return false;
        }
    }

    /**
     * Translates the given keycode and returns the GFE keycode
     * @param keycode the code to be translated
     * @return a GFE keycode for the given keycode
     */
    public static short translate(int keycode) {
        int translated;
        
        // This is a poor man's mapping between Android key codes
        // and Windows VK_* codes. For all defined VK_ codes, see:
        // https://msdn.microsoft.com/en-us/library/windows/desktop/dd375731(v=vs.85).aspx
        if (keycode >= KeyEvent.KEYCODE_0 &&
            keycode <= KeyEvent.KEYCODE_9) {
            translated = (keycode - KeyEvent.KEYCODE_0) + VK_0;
        }
        else if (keycode >= KeyEvent.KEYCODE_A &&
                 keycode <= KeyEvent.KEYCODE_Z) {
            translated = (keycode - KeyEvent.KEYCODE_A) + VK_A;
        }
        else if (keycode >= KeyEvent.KEYCODE_NUMPAD_0 &&
                 keycode <= KeyEvent.KEYCODE_NUMPAD_9) {
            translated = (keycode - KeyEvent.KEYCODE_NUMPAD_0) + VK_NUMPAD0;
        }
        else if (keycode >= KeyEvent.KEYCODE_F1 &&
                 keycode <= KeyEvent.KEYCODE_F12) {
            translated = (keycode - KeyEvent.KEYCODE_F1) + VK_F1;
        }
        else {
            switch (keycode) {
            case KeyEvent.KEYCODE_ALT_LEFT:
                translated = 0xA4;
                break;

            case KeyEvent.KEYCODE_ALT_RIGHT:
                translated = 0xA5;
                break;
                
            // translated = Winkey 0x5B;
            case KeyEvent.KEYCODE_TV:
                translated = 0x5b;
                break;
                
            case KeyEvent.KEYCODE_BACKSLASH:
                translated = 0xdc;
                break;
                
            case KeyEvent.KEYCODE_CAPS_LOCK:
                translated = VK_CAPS_LOCK;
                break;
                
            case KeyEvent.KEYCODE_CLEAR:
                translated = VK_CLEAR;
                break;
                
            case KeyEvent.KEYCODE_COMMA:
                translated = 0xbc;
                break;
                
            case KeyEvent.KEYCODE_CTRL_LEFT:
                translated = 0xA2;
                break;

            case KeyEvent.KEYCODE_CTRL_RIGHT:
                translated = 0xA3;
                break;
                
            case KeyEvent.KEYCODE_DEL:
                translated = VK_BACK_SPACE;
                break;
                
            case KeyEvent.KEYCODE_ENTER:
                translated = 0x0d;
                break;

            case KeyEvent.KEYCODE_PLUS:
            case KeyEvent.KEYCODE_EQUALS:
                translated = 0xbb;
                break;
                
            case KeyEvent.KEYCODE_ESCAPE:
                translated = VK_ESCAPE;
                break;
                
            case KeyEvent.KEYCODE_FORWARD_DEL:
                translated = 0x2e;
                break;
                
            case KeyEvent.KEYCODE_INSERT:
                translated = 0x2d;
                break;
                
            case KeyEvent.KEYCODE_LEFT_BRACKET:
                translated = 0xdb;
                break;

            case KeyEvent.KEYCODE_META_LEFT:
                translated = 0x5b;
                break;

            case KeyEvent.KEYCODE_META_RIGHT:
                translated = 0x5c;
                break;

            case KeyEvent.KEYCODE_MINUS:
                translated = 0xbd;
                break;
                
            case KeyEvent.KEYCODE_MOVE_END:
                translated = VK_END;
                break;
                
            case KeyEvent.KEYCODE_MOVE_HOME:
                translated = VK_HOME;
                break;
                
            case KeyEvent.KEYCODE_NUM_LOCK:
                translated = VK_NUM_LOCK;
                break;
                
            case KeyEvent.KEYCODE_PAGE_DOWN:
                translated = VK_PAGE_DOWN;
                break;
                
            case KeyEvent.KEYCODE_PAGE_UP:
                translated = VK_PAGE_UP;
                break;
                
            case KeyEvent.KEYCODE_PERIOD:
                translated = 0xbe;
                break;
                
            case KeyEvent.KEYCODE_RIGHT_BRACKET:
                translated = 0xdd;
                break;
                
            case KeyEvent.KEYCODE_SCROLL_LOCK:
                translated = VK_SCROLL_LOCK;
                break;
                
            case KeyEvent.KEYCODE_SEMICOLON:
                translated = 0xba;
                break;
                
            case KeyEvent.KEYCODE_SHIFT_LEFT:
                translated = 0xA0;
                break;

            case KeyEvent.KEYCODE_SHIFT_RIGHT:
                translated = 0xA1;
                break;
                
            case KeyEvent.KEYCODE_SLASH:
                translated = 0xbf;
                break;
                
            case KeyEvent.KEYCODE_SPACE:
                translated = VK_SPACE;
                break;
                
            case KeyEvent.KEYCODE_SYSRQ:
                // Android defines this as SysRq/PrntScrn
                translated = VK_PRINTSCREEN;
                break;
                
            case KeyEvent.KEYCODE_DVR:
                translated = VK_TAB;
                break;
                
            case KeyEvent.KEYCODE_DPAD_LEFT:
                translated = VK_LEFT;
                break;
                
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                translated = VK_RIGHT;
                break;
                
            case KeyEvent.KEYCODE_DPAD_UP:
                translated = VK_UP;
                break;
                
            case KeyEvent.KEYCODE_DPAD_DOWN:
                translated = VK_DOWN;
                break;
                
            case KeyEvent.KEYCODE_GRAVE:
                translated = VK_BACK_QUOTE;
                break;
                
            case KeyEvent.KEYCODE_APOSTROPHE:
                translated = 0xde;
                break;
                
            case KeyEvent.KEYCODE_BREAK:
                translated = VK_PAUSE;
                break;

            case KeyEvent.KEYCODE_NUMPAD_DIVIDE:
                translated = 0x6F;
                break;

            case KeyEvent.KEYCODE_NUMPAD_MULTIPLY:
                translated = 0x6A;
                break;

            case KeyEvent.KEYCODE_NUMPAD_SUBTRACT:
                translated = 0x6D;
                break;

            case KeyEvent.KEYCODE_NUMPAD_ADD:
                translated = 0x6B;
                break;

            case KeyEvent.KEYCODE_NUMPAD_DOT:
                translated = 0x6E;
                break;

            case KeyEvent.KEYCODE_AT:
                translated = 2 + VK_0;
                break;

            case KeyEvent.KEYCODE_POUND:
                translated = 3 + VK_0;
                break;

            case KeyEvent.KEYCODE_STAR:
                translated = 8 + VK_0;
                break;

            default:
                System.out.println("No key for "+keycode);
                return 0;
            }
        }
        
        return (short) ((KEY_PREFIX << 8) | translated);
    }

}
