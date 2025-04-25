import java.time.LocalDateTime;

public class Buy_records {
    private Integer id;
    private String username;
    private LocalDateTime buytime;
    private Integer buynum;
    private String ip;

    public Buy_records(Integer id, String username, LocalDateTime buytime, Integer buynum, String ip) {
        this.id = id;
        this.username = username;
        this.buytime = buytime;
        this.buynum = buynum;
        this.ip = ip;
    }

    public Buy_records() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDateTime getBuytime() {
        return buytime;
    }

    public void setBuytime(LocalDateTime buytime) {
        this.buytime = buytime;
    }

    public Integer getBuynum() {
        return buynum;
    }

    public void setBuynum(Integer buynum) {
        this.buynum = buynum;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
