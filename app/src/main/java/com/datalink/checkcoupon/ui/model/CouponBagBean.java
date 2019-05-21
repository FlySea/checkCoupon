package com.datalink.checkcoupon.ui.model;

import java.util.List;

public class CouponBagBean {


    /**
     * code : 200
     * data : {"current_page":1,"data":[{"id":14,"coupon_code_id":41063,"shop_id":1543,"trade_id":null,"order_id":null,"reservation_id":5,"clerk_id":null,"created_at":"2018-02-07 06:38:04","updated_at":"2018-02-07 06:38:04","status":0,"coupon_code":{"id":41063,"coupon_id":16,"status":3,"code":"Cjxk40SRtN7DwfURL4","password":null,"member_id":6221,"distributor_id":null,"mobile_phone":null,"take_at":"2018-02-06 08:00:00","begin_at":"2018-02-08 01:51:15","finish_at":"2018-03-10 01:51:15","created_at":"2018-02-07 01:51:15","updated_at":"2018-02-07 06:38:12","status_readable":"已使用","coupon":{"id":16,"merchant_id":1,"name":"不使用","code":null,"type":"card","sum":null,"market_type":"limit","market_value":"5","use_multiple":0,"threshold":null,"user_limit":0,"is_need_phone_activate":0,"user_manual":null,"valid_type":3,"valid_days":2,"callback_url":null,"price":0,"exchange_price":0,"begin_at":null,"finish_at":null,"created_at":"2018-01-25 20:28:16","updated_at":"2018-02-07 22:14:38","card_type":null,"market_value_readable":null},"member":{"id":6221,"email":null,"outer_member_id":null,"user_id":null,"source":"mina","app_id":null,"weixin_openid":"oL-gX0UUSSV03RNg2LQ-_V4BXXms","weixin_union_id":null,"merchant_id":1,"name":"zxw","nickname":"","avatar":"https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJoTiadO7a9vicsoeKzUN9fma5dKIIF9asLI0v6KCKu07mlpdh0eMgDEAUgYjaSBsicry0owkB6EE5AQ/0","gender":1,"province":"","city":"","mobile_phone":"18819450951","traded_num":7,"traded_money":10,"points":null,"address_id":null,"parent_id":null,"invitation":null,"status":"valid","rejected_options":null,"birthday":null,"subscribe_at":null,"deleted_at":null,"created_at":"2018-02-07 01:39:31","updated_at":"2018-02-24 00:25:27","source_readable":"小程序"}}}],"first_page_url":"http://erp.cblink.test/api/shop-exchanges/code-used?page=1","from":1,"next_page_url":null,"path":"http://erp.cblink.test/api/shop-exchanges/code-used","per_page":20,"prev_page_url":null,"to":3}
     */

    private int code;
    private DataBeanX data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
        this.data = data;
    }

    public static class DataBeanX {
        /**
         * current_page : 1
         * data : [{"id":14,"coupon_code_id":41063,"shop_id":1543,"trade_id":null,"order_id":null,"reservation_id":5,"clerk_id":null,"created_at":"2018-02-07 06:38:04","updated_at":"2018-02-07 06:38:04","status":0,"coupon_code":{"id":41063,"coupon_id":16,"status":3,"code":"Cjxk40SRtN7DwfURL4","password":null,"member_id":6221,"distributor_id":null,"mobile_phone":null,"take_at":"2018-02-06 08:00:00","begin_at":"2018-02-08 01:51:15","finish_at":"2018-03-10 01:51:15","created_at":"2018-02-07 01:51:15","updated_at":"2018-02-07 06:38:12","status_readable":"已使用","coupon":{"id":16,"merchant_id":1,"name":"不使用","code":null,"type":"card","sum":null,"market_type":"limit","market_value":"5","use_multiple":0,"threshold":null,"user_limit":0,"is_need_phone_activate":0,"user_manual":null,"valid_type":3,"valid_days":2,"callback_url":null,"price":0,"exchange_price":0,"begin_at":null,"finish_at":null,"created_at":"2018-01-25 20:28:16","updated_at":"2018-02-07 22:14:38","card_type":null,"market_value_readable":null},"member":{"id":6221,"email":null,"outer_member_id":null,"user_id":null,"source":"mina","app_id":null,"weixin_openid":"oL-gX0UUSSV03RNg2LQ-_V4BXXms","weixin_union_id":null,"merchant_id":1,"name":"zxw","nickname":"","avatar":"https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJoTiadO7a9vicsoeKzUN9fma5dKIIF9asLI0v6KCKu07mlpdh0eMgDEAUgYjaSBsicry0owkB6EE5AQ/0","gender":1,"province":"","city":"","mobile_phone":"18819450951","traded_num":7,"traded_money":10,"points":null,"address_id":null,"parent_id":null,"invitation":null,"status":"valid","rejected_options":null,"birthday":null,"subscribe_at":null,"deleted_at":null,"created_at":"2018-02-07 01:39:31","updated_at":"2018-02-24 00:25:27","source_readable":"小程序"}}}]
         * first_page_url : http://erp.cblink.test/api/shop-exchanges/code-used?page=1
         * from : 1
         * next_page_url : null
         * path : http://erp.cblink.test/api/shop-exchanges/code-used
         * per_page : 20
         * prev_page_url : null
         * to : 3
         */

        private int current_page;
        private String first_page_url;
        private int from;
        private String next_page_url;
        private String path;
        private int per_page;
        private String prev_page_url;
        private int to;
        private List<DataBean> data;

        public int getCurrent_page() {
            return current_page;
        }

        public void setCurrent_page(int current_page) {
            this.current_page = current_page;
        }

        public String getFirst_page_url() {
            return first_page_url;
        }

        public void setFirst_page_url(String first_page_url) {
            this.first_page_url = first_page_url;
        }

        public int getFrom() {
            return from;
        }

        public void setFrom(int from) {
            this.from = from;
        }

        public String getNext_page_url() {
            return next_page_url;
        }

        public void setNext_page_url(String next_page_url) {
            this.next_page_url = next_page_url;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public int getPer_page() {
            return per_page;
        }

        public void setPer_page(int per_page) {
            this.per_page = per_page;
        }

        public String getPrev_page_url() {
            return prev_page_url;
        }

        public void setPrev_page_url(String prev_page_url) {
            this.prev_page_url = prev_page_url;
        }

        public int getTo() {
            return to;
        }

        public void setTo(int to) {
            this.to = to;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * id : 14
             * coupon_code_id : 41063
             * shop_id : 1543
             * trade_id : null
             * order_id : null
             * reservation_id : 5
             * clerk_id : null
             * created_at : 2018-02-07 06:38:04
             * updated_at : 2018-02-07 06:38:04
             * status : 0
             * coupon_code : {"id":41063,"coupon_id":16,"status":3,"code":"Cjxk40SRtN7DwfURL4","password":null,"member_id":6221,"distributor_id":null,"mobile_phone":null,"take_at":"2018-02-06 08:00:00","begin_at":"2018-02-08 01:51:15","finish_at":"2018-03-10 01:51:15","created_at":"2018-02-07 01:51:15","updated_at":"2018-02-07 06:38:12","status_readable":"已使用","coupon":{"id":16,"merchant_id":1,"name":"不使用","code":null,"type":"card","sum":null,"market_type":"limit","market_value":"5","use_multiple":0,"threshold":null,"user_limit":0,"is_need_phone_activate":0,"user_manual":null,"valid_type":3,"valid_days":2,"callback_url":null,"price":0,"exchange_price":0,"begin_at":null,"finish_at":null,"created_at":"2018-01-25 20:28:16","updated_at":"2018-02-07 22:14:38","card_type":null,"market_value_readable":null},"member":{"id":6221,"email":null,"outer_member_id":null,"user_id":null,"source":"mina","app_id":null,"weixin_openid":"oL-gX0UUSSV03RNg2LQ-_V4BXXms","weixin_union_id":null,"merchant_id":1,"name":"zxw","nickname":"","avatar":"https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJoTiadO7a9vicsoeKzUN9fma5dKIIF9asLI0v6KCKu07mlpdh0eMgDEAUgYjaSBsicry0owkB6EE5AQ/0","gender":1,"province":"","city":"","mobile_phone":"18819450951","traded_num":7,"traded_money":10,"points":null,"address_id":null,"parent_id":null,"invitation":null,"status":"valid","rejected_options":null,"birthday":null,"subscribe_at":null,"deleted_at":null,"created_at":"2018-02-07 01:39:31","updated_at":"2018-02-24 00:25:27","source_readable":"小程序"}}
             */

            private int id;
            private int coupon_code_id;
            private int shop_id;
            private String trade_id;
            private String order_id;
            private int reservation_id;
            private String clerk_id;
            private String created_at;
            private String updated_at;
            private int status;
            private CouponCodeBean coupon_code;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getCoupon_code_id() {
                return coupon_code_id;
            }

            public void setCoupon_code_id(int coupon_code_id) {
                this.coupon_code_id = coupon_code_id;
            }

            public int getShop_id() {
                return shop_id;
            }

            public void setShop_id(int shop_id) {
                this.shop_id = shop_id;
            }

            public String getTrade_id() {
                return trade_id;
            }

            public void setTrade_id(String trade_id) {
                this.trade_id = trade_id;
            }

            public String getOrder_id() {
                return order_id;
            }

            public void setOrder_id(String order_id) {
                this.order_id = order_id;
            }

            public int getReservation_id() {
                return reservation_id;
            }

            public void setReservation_id(int reservation_id) {
                this.reservation_id = reservation_id;
            }

            public String getClerk_id() {
                return clerk_id;
            }

            public void setClerk_id(String clerk_id) {
                this.clerk_id = clerk_id;
            }

            public String getCreated_at() {
                return created_at;
            }

            public void setCreated_at(String created_at) {
                this.created_at = created_at;
            }

            public String getUpdated_at() {
                return updated_at;
            }

            public void setUpdated_at(String updated_at) {
                this.updated_at = updated_at;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public CouponCodeBean getCoupon_code() {
                return coupon_code;
            }

            public void setCoupon_code(CouponCodeBean coupon_code) {
                this.coupon_code = coupon_code;
            }

            public static class CouponCodeBean {
                /**
                 * id : 41063
                 * coupon_id : 16
                 * status : 3
                 * code : Cjxk40SRtN7DwfURL4
                 * password : null
                 * member_id : 6221
                 * distributor_id : null
                 * mobile_phone : null
                 * take_at : 2018-02-06 08:00:00
                 * begin_at : 2018-02-08 01:51:15
                 * finish_at : 2018-03-10 01:51:15
                 * created_at : 2018-02-07 01:51:15
                 * updated_at : 2018-02-07 06:38:12
                 * status_readable : 已使用
                 * coupon : {"id":16,"merchant_id":1,"name":"不使用","code":null,"type":"card","sum":null,"market_type":"limit","market_value":"5","use_multiple":0,"threshold":null,"user_limit":0,"is_need_phone_activate":0,"user_manual":null,"valid_type":3,"valid_days":2,"callback_url":null,"price":0,"exchange_price":0,"begin_at":null,"finish_at":null,"created_at":"2018-01-25 20:28:16","updated_at":"2018-02-07 22:14:38","card_type":null,"market_value_readable":null}
                 * member : {"id":6221,"email":null,"outer_member_id":null,"user_id":null,"source":"mina","app_id":null,"weixin_openid":"oL-gX0UUSSV03RNg2LQ-_V4BXXms","weixin_union_id":null,"merchant_id":1,"name":"zxw","nickname":"","avatar":"https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJoTiadO7a9vicsoeKzUN9fma5dKIIF9asLI0v6KCKu07mlpdh0eMgDEAUgYjaSBsicry0owkB6EE5AQ/0","gender":1,"province":"","city":"","mobile_phone":"18819450951","traded_num":7,"traded_money":10,"points":null,"address_id":null,"parent_id":null,"invitation":null,"status":"valid","rejected_options":null,"birthday":null,"subscribe_at":null,"deleted_at":null,"created_at":"2018-02-07 01:39:31","updated_at":"2018-02-24 00:25:27","source_readable":"小程序"}
                 */

                private int id;
                private int coupon_id;
                private int status;
                private String code;
                private String password;
                private int member_id;
                private String distributor_id;
                private String mobile_phone;
                private String take_at;
                private String begin_at;
                private String finish_at;
                private String created_at;
                private String updated_at;
                private String status_readable;
                private CouponBean coupon;
                private MemberBean member;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getCoupon_id() {
                    return coupon_id;
                }

                public void setCoupon_id(int coupon_id) {
                    this.coupon_id = coupon_id;
                }

                public int getStatus() {
                    return status;
                }

                public void setStatus(int status) {
                    this.status = status;
                }

                public String getCode() {
                    return code;
                }

                public void setCode(String code) {
                    this.code = code;
                }

                public String getPassword() {
                    return password;
                }

                public void setPassword(String password) {
                    this.password = password;
                }

                public int getMember_id() {
                    return member_id;
                }

                public void setMember_id(int member_id) {
                    this.member_id = member_id;
                }

                public String getDistributor_id() {
                    return distributor_id;
                }

                public void setDistributor_id(String distributor_id) {
                    this.distributor_id = distributor_id;
                }

                public String getMobile_phone() {
                    return mobile_phone;
                }

                public void setMobile_phone(String mobile_phone) {
                    this.mobile_phone = mobile_phone;
                }

                public String getTake_at() {
                    return take_at;
                }

                public void setTake_at(String take_at) {
                    this.take_at = take_at;
                }

                public String getBegin_at() {
                    return begin_at;
                }

                public void setBegin_at(String begin_at) {
                    this.begin_at = begin_at;
                }

                public String getFinish_at() {
                    return finish_at;
                }

                public void setFinish_at(String finish_at) {
                    this.finish_at = finish_at;
                }

                public String getCreated_at() {
                    return created_at;
                }

                public void setCreated_at(String created_at) {
                    this.created_at = created_at;
                }

                public String getUpdated_at() {
                    return updated_at;
                }

                public void setUpdated_at(String updated_at) {
                    this.updated_at = updated_at;
                }

                public String getStatus_readable() {
                    return status_readable;
                }

                public void setStatus_readable(String status_readable) {
                    this.status_readable = status_readable;
                }

                public CouponBean getCoupon() {
                    return coupon;
                }

                public void setCoupon(CouponBean coupon) {
                    this.coupon = coupon;
                }

                public MemberBean getMember() {
                    return member;
                }

                public void setMember(MemberBean member) {
                    this.member = member;
                }

                public static class CouponBean {
                    /**
                     * id : 16
                     * merchant_id : 1
                     * name : 不使用
                     * code : null
                     * type : card
                     * sum : null
                     * market_type : limit
                     * market_value : 5
                     * use_multiple : 0
                     * threshold : null
                     * user_limit : 0
                     * is_need_phone_activate : 0
                     * user_manual : null
                     * valid_type : 3
                     * valid_days : 2
                     * callback_url : null
                     * price : 0
                     * exchange_price : 0
                     * begin_at : null
                     * finish_at : null
                     * created_at : 2018-01-25 20:28:16
                     * updated_at : 2018-02-07 22:14:38
                     * card_type : null
                     * market_value_readable : null
                     */

                    private int id;
                    private int merchant_id;
                    private String name;
                    private String code;
                    private String type;
                    private String sum;
                    private String market_type;
                    private String market_value;
                    private int use_multiple;
                    private String threshold;
                    private int user_limit;
                    private int is_need_phone_activate;
                    private String user_manual;
                    private int valid_type;
                    private int valid_days;
                    private String callback_url;
                    private int price;
                    private int exchange_price;
                    private String begin_at;
                    private String finish_at;
                    private String created_at;
                    private String updated_at;
                    private String card_type;
                    private String market_value_readable;

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }

                    public int getMerchant_id() {
                        return merchant_id;
                    }

                    public void setMerchant_id(int merchant_id) {
                        this.merchant_id = merchant_id;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public String getCode() {
                        return code;
                    }

                    public void setCode(String code) {
                        this.code = code;
                    }

                    public String getType() {
                        return type;
                    }

                    public void setType(String type) {
                        this.type = type;
                    }

                    public String getSum() {
                        return sum;
                    }

                    public void setSum(String sum) {
                        this.sum = sum;
                    }

                    public String getMarket_type() {
                        return market_type;
                    }

                    public void setMarket_type(String market_type) {
                        this.market_type = market_type;
                    }

                    public String getMarket_value() {
                        return market_value;
                    }

                    public void setMarket_value(String market_value) {
                        this.market_value = market_value;
                    }

                    public int getUse_multiple() {
                        return use_multiple;
                    }

                    public void setUse_multiple(int use_multiple) {
                        this.use_multiple = use_multiple;
                    }

                    public String getThreshold() {
                        return threshold;
                    }

                    public void setThreshold(String threshold) {
                        this.threshold = threshold;
                    }

                    public int getUser_limit() {
                        return user_limit;
                    }

                    public void setUser_limit(int user_limit) {
                        this.user_limit = user_limit;
                    }

                    public int getIs_need_phone_activate() {
                        return is_need_phone_activate;
                    }

                    public void setIs_need_phone_activate(int is_need_phone_activate) {
                        this.is_need_phone_activate = is_need_phone_activate;
                    }

                    public String getUser_manual() {
                        return user_manual;
                    }

                    public void setUser_manual(String user_manual) {
                        this.user_manual = user_manual;
                    }

                    public int getValid_type() {
                        return valid_type;
                    }

                    public void setValid_type(int valid_type) {
                        this.valid_type = valid_type;
                    }

                    public int getValid_days() {
                        return valid_days;
                    }

                    public void setValid_days(int valid_days) {
                        this.valid_days = valid_days;
                    }

                    public String getCallback_url() {
                        return callback_url;
                    }

                    public void setCallback_url(String callback_url) {
                        this.callback_url = callback_url;
                    }

                    public int getPrice() {
                        return price;
                    }

                    public void setPrice(int price) {
                        this.price = price;
                    }

                    public int getExchange_price() {
                        return exchange_price;
                    }

                    public void setExchange_price(int exchange_price) {
                        this.exchange_price = exchange_price;
                    }

                    public String getBegin_at() {
                        return begin_at;
                    }

                    public void setBegin_at(String begin_at) {
                        this.begin_at = begin_at;
                    }

                    public String getFinish_at() {
                        return finish_at;
                    }

                    public void setFinish_at(String finish_at) {
                        this.finish_at = finish_at;
                    }

                    public String getCreated_at() {
                        return created_at;
                    }

                    public void setCreated_at(String created_at) {
                        this.created_at = created_at;
                    }

                    public String getUpdated_at() {
                        return updated_at;
                    }

                    public void setUpdated_at(String updated_at) {
                        this.updated_at = updated_at;
                    }

                    public String getCard_type() {
                        return card_type;
                    }

                    public void setCard_type(String card_type) {
                        this.card_type = card_type;
                    }

                    public String getMarket_value_readable() {
                        return market_value_readable;
                    }

                    public void setMarket_value_readable(String market_value_readable) {
                        this.market_value_readable = market_value_readable;
                    }
                }

                public static class MemberBean {
                    /**
                     * id : 6221
                     * email : null
                     * outer_member_id : null
                     * user_id : null
                     * source : mina
                     * app_id : null
                     * weixin_openid : oL-gX0UUSSV03RNg2LQ-_V4BXXms
                     * weixin_union_id : null
                     * merchant_id : 1
                     * name : zxw
                     * nickname : 
                     * avatar : https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJoTiadO7a9vicsoeKzUN9fma5dKIIF9asLI0v6KCKu07mlpdh0eMgDEAUgYjaSBsicry0owkB6EE5AQ/0
                     * gender : 1
                     * province : 
                     * city : 
                     * mobile_phone : 18819450951
                     * traded_num : 7
                     * traded_money : 10
                     * points : null
                     * address_id : null
                     * parent_id : null
                     * invitation : null
                     * status : valid
                     * rejected_options : null
                     * birthday : null
                     * subscribe_at : null
                     * deleted_at : null
                     * created_at : 2018-02-07 01:39:31
                     * updated_at : 2018-02-24 00:25:27
                     * source_readable : 小程序
                     */

                    private int id;
                    private String email;
                    private String outer_member_id;
                    private String user_id;
                    private String source;
                    private String app_id;
                    private String weixin_openid;
                    private String weixin_union_id;
                    private int merchant_id;
                    private String name;
                    private String nickname;
                    private String avatar;
                    private int gender;
                    private String province;
                    private String city;
                    private String mobile_phone;
                    private int traded_num;
                    private int traded_money;
                    private String points;
                    private String address_id;
                    private String parent_id;
                    private String invitation;
                    private String status;
                    private String rejected_options;
                    private String birthday;
                    private String subscribe_at;
                    private String deleted_at;
                    private String created_at;
                    private String updated_at;
                    private String source_readable;

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }

                    public String getEmail() {
                        return email;
                    }

                    public void setEmail(String email) {
                        this.email = email;
                    }

                    public String getOuter_member_id() {
                        return outer_member_id;
                    }

                    public void setOuter_member_id(String outer_member_id) {
                        this.outer_member_id = outer_member_id;
                    }

                    public String getUser_id() {
                        return user_id;
                    }

                    public void setUser_id(String user_id) {
                        this.user_id = user_id;
                    }

                    public String getSource() {
                        return source;
                    }

                    public void setSource(String source) {
                        this.source = source;
                    }

                    public String getApp_id() {
                        return app_id;
                    }

                    public void setApp_id(String app_id) {
                        this.app_id = app_id;
                    }

                    public String getWeixin_openid() {
                        return weixin_openid;
                    }

                    public void setWeixin_openid(String weixin_openid) {
                        this.weixin_openid = weixin_openid;
                    }

                    public String getWeixin_union_id() {
                        return weixin_union_id;
                    }

                    public void setWeixin_union_id(String weixin_union_id) {
                        this.weixin_union_id = weixin_union_id;
                    }

                    public int getMerchant_id() {
                        return merchant_id;
                    }

                    public void setMerchant_id(int merchant_id) {
                        this.merchant_id = merchant_id;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public String getNickname() {
                        return nickname;
                    }

                    public void setNickname(String nickname) {
                        this.nickname = nickname;
                    }

                    public String getAvatar() {
                        return avatar;
                    }

                    public void setAvatar(String avatar) {
                        this.avatar = avatar;
                    }

                    public int getGender() {
                        return gender;
                    }

                    public void setGender(int gender) {
                        this.gender = gender;
                    }

                    public String getProvince() {
                        return province;
                    }

                    public void setProvince(String province) {
                        this.province = province;
                    }

                    public String getCity() {
                        return city;
                    }

                    public void setCity(String city) {
                        this.city = city;
                    }

                    public String getMobile_phone() {
                        return mobile_phone;
                    }

                    public void setMobile_phone(String mobile_phone) {
                        this.mobile_phone = mobile_phone;
                    }

                    public int getTraded_num() {
                        return traded_num;
                    }

                    public void setTraded_num(int traded_num) {
                        this.traded_num = traded_num;
                    }

                    public int getTraded_money() {
                        return traded_money;
                    }

                    public void setTraded_money(int traded_money) {
                        this.traded_money = traded_money;
                    }

                    public String getPoints() {
                        return points;
                    }

                    public void setPoints(String points) {
                        this.points = points;
                    }

                    public String getAddress_id() {
                        return address_id;
                    }

                    public void setAddress_id(String address_id) {
                        this.address_id = address_id;
                    }

                    public String getParent_id() {
                        return parent_id;
                    }

                    public void setParent_id(String parent_id) {
                        this.parent_id = parent_id;
                    }

                    public String getInvitation() {
                        return invitation;
                    }

                    public void setInvitation(String invitation) {
                        this.invitation = invitation;
                    }

                    public String getStatus() {
                        return status;
                    }

                    public void setStatus(String status) {
                        this.status = status;
                    }

                    public String getRejected_options() {
                        return rejected_options;
                    }

                    public void setRejected_options(String rejected_options) {
                        this.rejected_options = rejected_options;
                    }

                    public String getBirthday() {
                        return birthday;
                    }

                    public void setBirthday(String birthday) {
                        this.birthday = birthday;
                    }

                    public String getSubscribe_at() {
                        return subscribe_at;
                    }

                    public void setSubscribe_at(String subscribe_at) {
                        this.subscribe_at = subscribe_at;
                    }

                    public String getDeleted_at() {
                        return deleted_at;
                    }

                    public void setDeleted_at(String deleted_at) {
                        this.deleted_at = deleted_at;
                    }

                    public String getCreated_at() {
                        return created_at;
                    }

                    public void setCreated_at(String created_at) {
                        this.created_at = created_at;
                    }

                    public String getUpdated_at() {
                        return updated_at;
                    }

                    public void setUpdated_at(String updated_at) {
                        this.updated_at = updated_at;
                    }

                    public String getSource_readable() {
                        return source_readable;
                    }

                    public void setSource_readable(String source_readable) {
                        this.source_readable = source_readable;
                    }
                }
            }
        }
    }
}
