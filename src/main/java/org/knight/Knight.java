package org.knight;

public class Knight {

    private Integer x;
    private Integer y;

    public Knight(Integer x, Integer y) {
        super();
        this.x = x;
        this.y = y;
    }

    public static Knight knightOf(Integer x, Integer y) {
        return new Knight(x, y);
    }

    public Integer x() {
        return x;
    }

    public Integer y() {
        return y;
    }

    @Override
    public String toString() {
        return "Knight [x=" + x + ", y=" + y + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((x == null) ? 0 : x.hashCode());
        result = prime * result + ((y == null) ? 0 : y.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Knight other = (Knight) obj;
        if (x == null) {
            if (other.x != null)
                return false;
        } else if (!x.equals(other.x))
            return false;
        if (y == null) {
            if (other.y != null)
                return false;
        } else if (!y.equals(other.y))
            return false;
        return true;
    }

}
