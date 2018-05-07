
public  interface Observer {
    /**
     * Un observateur doit possÃ©der une mÃ©thode [update] dÃ©clenchant la mise Ã
     * jour.
     */
    public void update();

    /**
     * La version officielle de Java possÃ¨de des paramÃ¨tres prÃ©cisant le
     * changement qui a eu lieu.
     */
}
