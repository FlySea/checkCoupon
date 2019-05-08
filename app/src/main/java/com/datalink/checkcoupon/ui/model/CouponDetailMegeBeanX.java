package com.datalink.checkcoupon.ui.model;

public class CouponDetailMegeBeanX {

    /**
     * code : 200
     * data : {"coupon":{"id":608099,"coupon_id":108,"status":2,"code":null,"password":null,"member_id":451269,"distributor_id":null,"mobile_phone":null,"take_at":"2019-05-08 09:55:09","begin_at":"2019-05-08 00:00:00","finish_at":"2019-06-07 23:59:59","created_at":"2019-05-08 09:55:09","updated_at":"2019-05-08 09:55:09","status_readable":"待使用","coupon":{"id":108,"merchant_id":22,"name":"买一送一券(生日)","code":null,"type":"card","sum":2000000,"market_type":"buy_gift","market_value":"","use_multiple":0,"threshold":0,"user_limit":0,"is_need_phone_activate":0,"user_manual":"1、折扣力度：买一送一券(生日福利)\r\n2、商品类型：小程序点单全商品类别（包括堂食订单、外卖订单）\r\n3、使用时间：领取后30天内可用\r\n4、使用方法：注册会员用户进入YOTea小程序点单，进入订单页面的[优惠券]选择即可抵扣\r\n5、如需了解更多YO!券使用方法，请咨询小程序在线客服","valid_type":2,"valid_days":30,"callback_url":null,"price":0,"exchange_price":0,"begin_at":null,"finish_at":null,"created_at":"2019-05-05 15:49:32","updated_at":"2019-05-05 15:49:32","card_type":"买赠券","market_value_readable":null}},"id":1,"consumed_at":null,"created_at":"2019-03-27 19:09:10","display_status":"待核销","normalize_exchangeable_name":"雨果测试改名","normalize_exchangeable_image":"https://img.yzcdn.cn/upload_files/2018/01/17/Fnvb0VOOx4Zwu8nK7b2byBn6cC60.jpg?imageView2/2/w/600/h/0/q/75/format/jpg","exchange_coin":12,"pick_mode":"到店-丰盛町店","remaining_quantity":1,"member":{"id":124,"nickname":null,"mobile_phone":"18565801192"}}
     */

    private int code;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * coupon : {"id":608099,"coupon_id":108,"status":2,"code":null,"password":null,"member_id":451269,"distributor_id":null,"mobile_phone":null,"take_at":"2019-05-08 09:55:09","begin_at":"2019-05-08 00:00:00","finish_at":"2019-06-07 23:59:59","created_at":"2019-05-08 09:55:09","updated_at":"2019-05-08 09:55:09","status_readable":"待使用","coupon":{"id":108,"merchant_id":22,"name":"买一送一券(生日)","code":null,"type":"card","sum":2000000,"market_type":"buy_gift","market_value":"","use_multiple":0,"threshold":0,"user_limit":0,"is_need_phone_activate":0,"user_manual":"1、折扣力度：买一送一券(生日福利)\r\n2、商品类型：小程序点单全商品类别（包括堂食订单、外卖订单）\r\n3、使用时间：领取后30天内可用\r\n4、使用方法：注册会员用户进入YOTea小程序点单，进入订单页面的[优惠券]选择即可抵扣\r\n5、如需了解更多YO!券使用方法，请咨询小程序在线客服","valid_type":2,"valid_days":30,"callback_url":null,"price":0,"exchange_price":0,"begin_at":null,"finish_at":null,"created_at":"2019-05-05 15:49:32","updated_at":"2019-05-05 15:49:32","card_type":"买赠券","market_value_readable":null}}
         * id : 1
         * consumed_at : null
         * created_at : 2019-03-27 19:09:10
         * display_status : 待核销
         * normalize_exchangeable_name : 雨果测试改名
         * normalize_exchangeable_image : https://img.yzcdn.cn/upload_files/2018/01/17/Fnvb0VOOx4Zwu8nK7b2byBn6cC60.jpg?imageView2/2/w/600/h/0/q/75/format/jpg
         * exchange_coin : 12
         * pick_mode : 到店-丰盛町店
         * remaining_quantity : 1
         * member : {"id":124,"nickname":null,"mobile_phone":"18565801192"}
         */

        private CouponBeanX coupon;
        private int id;
        private String consumed_at;
        private String created_at;
        private String display_status;
        private String normalize_exchangeable_name;
        private String normalize_exchangeable_image;
        private int exchange_coin;
        private String pick_mode;
        private int remaining_quantity;
        private MemberBean member;

        public CouponBeanX getCoupon() {
            return coupon;
        }

        public void setCoupon(CouponBeanX coupon) {
            this.coupon = coupon;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getConsumed_at() {
            return consumed_at;
        }

        public void setConsumed_at(String consumed_at) {
            this.consumed_at = consumed_at;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getDisplay_status() {
            return display_status;
        }

        public void setDisplay_status(String display_status) {
            this.display_status = display_status;
        }

        public String getNormalize_exchangeable_name() {
            return normalize_exchangeable_name;
        }

        public void setNormalize_exchangeable_name(String normalize_exchangeable_name) {
            this.normalize_exchangeable_name = normalize_exchangeable_name;
        }

        public String getNormalize_exchangeable_image() {
            return normalize_exchangeable_image;
        }

        public void setNormalize_exchangeable_image(String normalize_exchangeable_image) {
            this.normalize_exchangeable_image = normalize_exchangeable_image;
        }

        public int getExchange_coin() {
            return exchange_coin;
        }

        public void setExchange_coin(int exchange_coin) {
            this.exchange_coin = exchange_coin;
        }

        public String getPick_mode() {
            return pick_mode;
        }

        public void setPick_mode(String pick_mode) {
            this.pick_mode = pick_mode;
        }

        public int getRemaining_quantity() {
            return remaining_quantity;
        }

        public void setRemaining_quantity(int remaining_quantity) {
            this.remaining_quantity = remaining_quantity;
        }

        public MemberBean getMember() {
            return member;
        }

        public void setMember(MemberBean member) {
            this.member = member;
        }

        public static class CouponBeanX {
            /**
             * id : 608099
             * coupon_id : 108
             * status : 2
             * code : null
             * password : null
             * member_id : 451269
             * distributor_id : null
             * mobile_phone : null
             * take_at : 2019-05-08 09:55:09
             * begin_at : 2019-05-08 00:00:00
             * finish_at : 2019-06-07 23:59:59
             * created_at : 2019-05-08 09:55:09
             * updated_at : 2019-05-08 09:55:09
             * status_readable : 待使用
             * coupon : {"id":108,"merchant_id":22,"name":"买一送一券(生日)","code":null,"type":"card","sum":2000000,"market_type":"buy_gift","market_value":"","use_multiple":0,"threshold":0,"user_limit":0,"is_need_phone_activate":0,"user_manual":"1、折扣力度：买一送一券(生日福利)\r\n2、商品类型：小程序点单全商品类别（包括堂食订单、外卖订单）\r\n3、使用时间：领取后30天内可用\r\n4、使用方法：注册会员用户进入YOTea小程序点单，进入订单页面的[优惠券]选择即可抵扣\r\n5、如需了解更多YO!券使用方法，请咨询小程序在线客服","valid_type":2,"valid_days":30,"callback_url":null,"price":0,"exchange_price":0,"begin_at":null,"finish_at":null,"created_at":"2019-05-05 15:49:32","updated_at":"2019-05-05 15:49:32","card_type":"买赠券","market_value_readable":null}
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

            public static class CouponBean {
                /**
                 * id : 108
                 * merchant_id : 22
                 * name : 买一送一券(生日)
                 * code : null
                 * type : card
                 * sum : 2000000
                 * market_type : buy_gift
                 * market_value :
                 * use_multiple : 0
                 * threshold : 0
                 * user_limit : 0
                 * is_need_phone_activate : 0
                 * user_manual : 1、折扣力度：买一送一券(生日福利)
                 2、商品类型：小程序点单全商品类别（包括堂食订单、外卖订单）
                 3、使用时间：领取后30天内可用
                 4、使用方法：注册会员用户进入YOTea小程序点单，进入订单页面的[优惠券]选择即可抵扣
                 5、如需了解更多YO!券使用方法，请咨询小程序在线客服
                 * valid_type : 2
                 * valid_days : 30
                 * callback_url : null
                 * price : 0
                 * exchange_price : 0
                 * begin_at : null
                 * finish_at : null
                 * created_at : 2019-05-05 15:49:32
                 * updated_at : 2019-05-05 15:49:32
                 * card_type : 买赠券
                 * market_value_readable : null
                 */

                private int id;
                private int merchant_id;
                private String name;
                private String code;
                private String type;
                private int sum;
                private String market_type;
                private String market_value;
                private int use_multiple;
                private int threshold;
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

                public int getSum() {
                    return sum;
                }

                public void setSum(int sum) {
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

                public int getThreshold() {
                    return threshold;
                }

                public void setThreshold(int threshold) {
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
        }

        public static class MemberBean {
            /**
             * id : 124
             * nickname : null
             * mobile_phone : 18565801192
             */

            private int id;
            private String nickname;
            private String mobile_phone;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getMobile_phone() {
                return mobile_phone;
            }

            public void setMobile_phone(String mobile_phone) {
                this.mobile_phone = mobile_phone;
            }
        }
    }
}
