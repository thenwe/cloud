package cn.itcast.order.util;

public class chat {
    public static void main(String[] args) {
        String sentence = "{猜测词}是遇到了马贼,{人名}说话的神情有些{形容词}，大概连他都不相信这种说法";
        String[] wordsToReplace = {"猜测词", "人名", "形容词"};
        String[] replacementWords = {"或许", "赵四", "僵硬"};

        String sentence1 = "对于{人名}这种{积极形容词}的{身份}来说，" +
                "他们不{感情1}战争，更不会{感情1}那些蛮人，{历史典故等事件}" +
                "甚至让他们觉得{程度副词}{感情}----但没有谁会拒绝{理想式名词}这种上天赐予的礼物";
        sentence1+="1";
        String[] wordsToReplace1 = {"人名", "身份", "感情1", "历史典故等事件", "程度副词", "感情", "积极形容词","理想式名词"};
        String[] replacementWords1 = {"张三", "武将", "畏惧", "割地赔款", "极其", "羞耻", "身经百战","和平"};
        String result = replaceWordsInSentence(sentence, wordsToReplace, replacementWords);
        String result1 = replaceWordsInSentence(sentence1, wordsToReplace1, replacementWords1);
        System.out.println(result);
        System.out.println(result1);
    }

    public static String replaceWordsInSentence(String sentence, String[] wordsToReplace, String[] replacementWords) {
        for (int i = 0; i < wordsToReplace.length; i++) {
            sentence = sentence.replace("{" + wordsToReplace[i] + "}", replacementWords[i]);
        }
        return sentence;
    }
}
